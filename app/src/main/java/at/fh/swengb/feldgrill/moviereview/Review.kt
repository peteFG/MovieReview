package at.fh.swengb.feldgrill.moviereview

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Review(val reviewValue: Double, val reviewText: String) {

}