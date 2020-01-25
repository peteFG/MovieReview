package at.fh.swengb.feldgrill.moviereview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val EXTRA_MOVIE_ID = "MOVIE_ID_EXTRA"
        val REQUEST_DETAILS = 1
    }

    val movieAdapter = MovieAdapter() {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra(EXTRA_MOVIE_ID, it.id)
        startActivityForResult(intent, REQUEST_DETAILS)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movie_recycler_view.layoutManager = GridLayoutManager(this,3)
        movie_recycler_view.adapter = movieAdapter

        MovieRepository.movieList(
            success = {

                movieAdapter.updateList(it)
            },
            error = {
                Log.e("ERROR", it)
            }
        )
    }
}
