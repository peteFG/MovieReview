package at.fh.swengb.feldgrill.moviereview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import at.fh.swengb.feldgrill.moviereview.MainActivity.Companion.EXTRA_MOVIE_ID
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)



        val movieId = intent.getStringExtra(MainActivity.EXTRA_MOVIE_ID)

            movie_details_title.text = MovieRepository.movieById(movieId)?.title
            movie_details_director_name.text = MovieRepository.movieById(movieId.toString())?.director?.name
            movie_details_plot_content.text = MovieRepository.movieById(movieId)?.plot
            movie_details_release_date.text = MovieRepository.movieById(movieId)?.release
            movie_details_genre_name.text = MovieRepository.movieById(movieId)?.genre?.description
            movie_details_actors_name.text = MovieRepository.movieById(movieId.toString())?.actors?.joinToString{it.name}
            var average = 0.0
            if(MovieRepository.movieById(movieId.toString())?.reviews!!.isNotEmpty()) {
                average = MovieRepository.movieById(movieId.toString())!!.reviewAverage()
            }
            movie_details_avg_review_bar.rating = average.toFloat()
            movie_details_average_review_value.text = average.toString()
            movie_details_review_amount.text = MovieRepository.movieById(movieId.toString())?.reviews?.count().toString()


        movie_details_rate_movie.setOnClickListener {
            val intent = Intent(this, MovieReviewActivity::class.java)
            intent.putExtra(EXTRA_MOVIE_ID, movieId)
            startActivity(intent)
        }




    }
}
