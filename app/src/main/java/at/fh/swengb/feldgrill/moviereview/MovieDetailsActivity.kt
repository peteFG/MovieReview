package at.fh.swengb.feldgrill.moviereview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import at.fh.swengb.feldgrill.moviereview.MainActivity.Companion.EXTRA_MOVIE_ID
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {



    companion object {
        val EXTRA_DETAILS_ID = "MOVIE_ID_EXTRA"
        val REQUEST_REVIEW = 1
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_REVIEW && resultCode == Activity.RESULT_OK){
            setResult(Activity.RESULT_OK)
            finish()
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)


        val movieId = intent.getStringExtra(EXTRA_MOVIE_ID)


        if (movieId == null) {
            finish()

        } else {
            val movie = MovieRepository.movieById(movieId)

            if(movie == null) {
                finish()
                return
            }

            movie_details_title.text = movie.title
            movie_details_director_name.text = movie.director?.name
            movie_details_plot_content.text = movie.plot
            movie_details_release_date.text = movie.release
            movie_details_genre_name.text = movie.genre?.description
            movie_details_actors_name.text = movie.actors?.joinToString { it.name }

            var average = 0.0
            if (movie != null && movie.reviews.isNotEmpty()) {
                average = movie.reviewAverage()
            }

            movie_details_avg_review_bar.rating = average.toFloat()
            movie_details_average_review_value.text = average.toString()
            movie_details_review_amount.text = movie.reviews?.count().toString()


            movie_details_rate_movie.setOnClickListener {
                val intent = Intent(this, MovieReviewActivity::class.java)
                intent.putExtra(EXTRA_DETAILS_ID, movieId)
                startActivityForResult(intent, REQUEST_REVIEW)
            }
        }
    }
}