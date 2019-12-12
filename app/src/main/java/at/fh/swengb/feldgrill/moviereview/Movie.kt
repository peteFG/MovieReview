package at.fh.swengb.feldgrill.moviereview

class Movie(
    val id: String,
    val title: String,
    val release:String,
    val plot: String,
    val genre: MovieGenre,
    val director: Person,
    val actors: List<Person>,
    val reviews: MutableList<Review>) {


    fun reviewAverage() : Double{
        var sum = 0.0
        reviews.forEach{
            sum += it.reviewValue
        }
        //val average =
        return String.format ("%.3f", sum/reviews.count()).toDouble()
        //return average
    }
}