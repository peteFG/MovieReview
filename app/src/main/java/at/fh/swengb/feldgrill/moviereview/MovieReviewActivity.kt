package at.fh.swengb.feldgrill.moviereview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import at.fh.swengb.feldgrill.moviereview.MainActivity.Companion.EXTRA_MOVIE_ID
import kotlinx.android.synthetic.main.activity_movie_review.*

class MovieReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_review)

        val movieId = intent.getStringExtra(MainActivity.EXTRA_MOVIE_ID)

        updateUi(movieId)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        } else {
            return super.onOptionsItemSelected(item)
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

            movie_rating_header.text = movie.title

            rate_movie.setOnClickListener {
                val reviewValue = movie_rating_bar.rating.toDouble()
                val reviewText = movie_feedback.text.toString()

                val newReview = Review(reviewValue, reviewText)
                MovieRepository.reviewMovie(movie.id, newReview)

                val resultIntent = Intent()
                setResult(Activity.RESULT_OK, resultIntent)
                Toast.makeText(this, "Your Review has been added!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    private fun handleMovieNotFound() {
        Toast.makeText(this, "Movie could not be found", Toast.LENGTH_LONG).show()
        finish()
    }

}