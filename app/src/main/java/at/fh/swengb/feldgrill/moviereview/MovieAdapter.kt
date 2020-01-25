package at.fh.swengb.feldgrill.moviereview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
        Glide
            .with(itemView)
            .load(movie.posterImagePath)
            .into(itemView.item_movie_image)

        itemView.setOnClickListener {
            clickListener(movie)
        }
    }

}
