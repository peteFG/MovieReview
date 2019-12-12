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

    /*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_review)

        val movieId = intent.getStringExtra(EXTRA_MOVIE_ID)

        if (movieId == null) {

            finish()
        } else {
            movie_rating_header.text = MovieRepository.movieById(movieId)?.title

            rate_movie.setOnClickListener {

                val newReview = Review(movie_rating_bar.rating.toDouble(),movie_feedback.text.toString())
                MovieRepository.reviewMovie(movieId,newReview)
                setResult(Activity.RESULT_OK)
                val intent = Intent(this, MovieDetailsActivity::class.java)
                intent.putExtra(EXTRA_MOVIE_ID, movieId)
                startActivity(intent)
                //finish()
            }
        }
    }
}
