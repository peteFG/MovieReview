package at.fh.swengb.feldgrill.moviereview

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Person(val name: String, val profileImagePath: String) {

}