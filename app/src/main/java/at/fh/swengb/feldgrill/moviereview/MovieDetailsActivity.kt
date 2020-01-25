package at.fh.swengb.feldgrill.moviereview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import at.fh.swengb.feldgrill.moviereview.MainActivity.Companion.EXTRA_MOVIE_ID
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_details.*
import java.math.RoundingMode
import java.text.DecimalFormat

class MovieDetailsActivity : AppCompatActivity() {



    companion object {
        //val REVIEW_MOVIE_REQUEST = 2
        val EXTRA_MOVIE_ID_RATING = "MOVIE_ID_RATING_EXTRA"
        val ADD_OR_EDIT_RATING_REQUEST = 1
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)


        val movieId = intent.getStringExtra(MainActivity.EXTRA_MOVIE_ID)
        updateUi(movieId)
    }


    private fun updateUi(movieId: String?) {

        if (movieId == null) {
            handleMovieNotFound()
        } else {

            movieDetails(movieId)

            movie_details_rate_movie.setOnClickListener {
                val ratingIntent = Intent(this, MovieReviewActivity::class.java)

                ratingIntent.putExtra(EXTRA_MOVIE_ID_RATING, movieId)
                startActivityForResult(ratingIntent, ADD_OR_EDIT_RATING_REQUEST)
            }
        }
    }

    private fun movieDetails(inputId: String){


        MovieRepository.movieDetailById(inputId,
            success = { val movie =  it
                    movie_details_title.text =  movie.title
                    movie_details_director_name.text = movie.director.name
                    movie_details_plot_content.text = movie.plot
                    movie_details_release_date.text = movie.release
                    movie_details_genre_name.text = movie.genres.joinToString(", ") { it}
                    movie_details_actors_name.text = movie.actors.joinToString(", ") { it.name }
                    movie_details_avg_review_bar.rating = movie.ratingAverage().toFloat()
                    movie_details_average_review_value.text = movie.ratingAverage().toString()
                    movie_details_review_amount.text = movie.reviews.count().toString()


                    Glide
                        .with(movie_details_image2)
                        .load(movie.posterImagePath)
                        .into(movie_details_image2)

                    Glide
                        .with(movie_details_image)
                        .load(movie.backdropImagePath)
                        .into(movie_details_image)

            },
            error = { Log.e("ERROR", it)})
    }

    private fun handleMovieNotFound() {
        Toast.makeText(this, "Movie could not be found", Toast.LENGTH_LONG).show()
        Log.e(getString(R.string.PASSING_ERROR),getString(R.string.PASSING_ERROR_CONTENT))
        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_OR_EDIT_RATING_REQUEST && resultCode == Activity.RESULT_OK) {


            val movieId = data?.getStringExtra(MovieReviewActivity.EXTRA_MOVIE_ID_REVIEW_RETURN)
            if(movieId != null){
                movieDetails(movieId)
            }
        }
    }
}


