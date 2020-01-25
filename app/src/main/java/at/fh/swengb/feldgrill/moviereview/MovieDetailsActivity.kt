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
        val REVIEW_MOVIE_REQUEST = 2
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)


        val movieId = intent.getStringExtra(MainActivity.EXTRA_MOVIE_ID)
        updateUi(movieId)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REVIEW_MOVIE_REQUEST && resultCode == Activity.RESULT_OK){
            val movieId = intent.getStringExtra(MainActivity.EXTRA_MOVIE_ID)
            updateUi(movieId)
            val resultIntent = Intent ()
            setResult(Activity.RESULT_OK, resultIntent)
        }
    }

    private fun updateUi(movieId: String?) {
        if (movieId == null) {
            handleMovieNotFound()
            return
        }

        val movie = MovieRepository.movieById(movieId)

        if (movie == null) {
            handleMovieNotFound()
        } else {
            movie_details_title.text = movie.title
            movie_details_director_name.text = movie.director.name
            movie_details_plot_content.text = movie.plot
            movie_details_release_date.text = movie.release
            movie_details_genre_name.text = movie.genre.description
            movie_details_actors_name.text = movie.actors.joinToString(", ") { it.name }
            movie_details_avg_review_bar.rating = movie.reviewAverage().toFloat()
            movie_details_average_review_value.text = movie.reviewAverage().toString()
            movie_details_review_amount.text = movie.reviews.count().toString()

            movie_details_rate_movie.setOnClickListener {
                val ratingIntent = Intent(this, MovieReviewActivity::class.java)
                ratingIntent.putExtra(MainActivity.EXTRA_MOVIE_ID, movie.id)
                startActivityForResult(ratingIntent, REVIEW_MOVIE_REQUEST)
            }
        }
    }

    private fun handleMovieNotFound() {
        Toast.makeText(this, "Movie could not be found", Toast.LENGTH_LONG).show()
        finish()
    }
}


