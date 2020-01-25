package at.fh.swengb.feldgrill.moviereview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import at.fh.swengb.feldgrill.moviereview.MainActivity.Companion.EXTRA_MOVIE_ID
import kotlinx.android.synthetic.main.activity_movie_review.*

class MovieReviewActivity : AppCompatActivity() {

    companion object{
        val EXTRA_MOVIE_ID_REVIEW_RETURN = "MOVIE_ID_REVIEW_RETURN_EXTRA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_review)

        val movieId = intent.getStringExtra(MovieDetailsActivity.EXTRA_MOVIE_ID_RATING)

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

        }


        if (movieId == null) {
            handleMovieNotFound()
        } else {

            MovieRepository.movieDetailById(movieId,
                success = { movie_rating_header.text =  it.title },
                error = { Log.e("ERROR", it)})



            rate_movie.setOnClickListener {

                val myMovieReviewObject = Review(
                    movie_rating_bar.rating.toDouble(),
                    movie_feedback.text.toString()
                )



                MovieRepository.reviewMovie( movieId, myMovieReviewObject,
                    success = {
                        Log.i("SUCCESS", "Review was added")
                        Toast.makeText(this,"Review added!",Toast.LENGTH_LONG).show()
                    },
                    error = { Log.e("ERROR", it)})

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_MOVIE_ID_REVIEW_RETURN, movieId)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }

        }
    }

    private fun handleMovieNotFound() {
        Toast.makeText(this, "Movie could not be found", Toast.LENGTH_LONG).show()
        finish()
    }

}