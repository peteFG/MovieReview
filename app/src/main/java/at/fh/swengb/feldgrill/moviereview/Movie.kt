package at.fh.swengb.feldgrill.moviereview

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
open class Movie(
    val id: String,
    val title: String,
    val release: String,
    val posterImagePath: String,
    val backdropImagePath: String,
    val reviews: MutableList<Review>)
    {


    fun ratingAverage() : Double{
        var sum = 0.0
        reviews.forEach{
            sum += it.reviewValue
        }
        return sum/reviews.count()
    }
}