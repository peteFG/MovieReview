package at.fh.swengb.feldgrill.moviereview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_movie_details.view.*
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(val clickListener: (movie: Movie) -> Unit): RecyclerView.Adapter<MovieViewHolder>() {
    private var movieList = listOf<Movie>()
    fun updateList(newList: List<Movie>) {
        movieList = newList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val movieItemView = inflater.inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(movieItemView, clickListener)
    }

    override fun getItemCount(): Int {
        return movieList.count()
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bindItem(movie)
    }
}

class MovieViewHolder(itemView: View, val clickListener: (movie: Movie) -> Unit): RecyclerView.ViewHolder(itemView) {
    fun bindItem(movie: Movie) {
        itemView.item_movie_title.text = movie.title
        itemView.item_movie_release.text = movie.release.drop(6)
        itemView.item_movie_actor.text = movie.actors[0].name
        itemView.item_movie_director.text = movie.director.name



        var average = 0.0
        if(movie.reviews.isNotEmpty()) {
            average=movie.reviewAverage()
        }

        itemView.item_movie_avg_review_bar.rating = average.toFloat()
        itemView.item_movie_avg_review_value.text = average.toString()
        itemView.item_movie_review_count.text = movie.reviews.count().toString()

        itemView.setOnClickListener {
            clickListener(movie)
        }
    }

}
