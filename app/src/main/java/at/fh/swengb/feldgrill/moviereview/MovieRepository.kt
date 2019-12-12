package at.fh.swengb.feldgrill.moviereview

object MovieRepository {
    private val movies: List<Movie>

    init {

        movies = listOf(
            Movie(
                "0",
                "Iron Man",
                "01.05.2008",
                "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.",
                MovieGenre.ACTION,
                Person("Jon Favreau","19.10.1966"),
                listOf(Person("Robert Downey jr.","04.04.1965"),Person("Gwyneth Paltrow","27.10.1972")),
                mutableListOf()
            ),
            Movie(
                "1",
                "The Incredible Hulk",
                "10.07.2008",
                "Bruce Banner, a scientist on the run from the U.S. Government, must find a cure for the monster he turns into, whenever he loses his temper.",
                MovieGenre.ROMANCE,
                Person("Louis Leterrier","17.06.1973"),
                listOf(Person("Edward Norton","18.10.1969"),Person("Liv Tyler","01.07.1977")),
                mutableListOf()
            ),
            Movie(
                "2",
                "Iron Man 2",
                "06.05.2010",
                "With the world now aware of his identity as Iron Man, Tony Stark must contend with both his declining health and a vengeful mad man with ties to his father's legacy.",
                MovieGenre.ACTION,
                Person("Jon Favreau","19.10.1966"),
                listOf(Person("Robert Downey jr.","04.04.1965"),Person("Mickey Rourke","16.10.1952")),
                mutableListOf()
            ),
            Movie(
                "3",
                "Thor",
                "28.04.2011",
                "The powerful but arrogant god Thor is cast out of Asgard to live amongst humans in Midgard (Earth), where he soon becomes one of their finest defenders.",
                MovieGenre.ACTION,
                Person("Kenneth Branagh","10.12.1960"),
                listOf(Person("Chris Hemsworth","11.08.1983"),Person("Anthony Hopkins","31.12.1937")),
                mutableListOf()
            ),
            Movie(
                "4",
                "Captain America: The First Avenger",
                "18.08.2011",
                "Steve Rogers, a rejected military soldier transforms into Captain America after taking a dose of a \"Super-Soldier serum\". But being Captain America comes at a price as he attempts to take down a war monger and a terrorist organization.",
                MovieGenre.ACTION,
                Person("Joe Johnston","13.05.1950"),
                listOf(Person("Chris Evans","13.06.1981"),Person("Hugo Weaving","04.04.1960")),
                mutableListOf()
            ),
            Movie(
                "5",
                "Marvel's The Avengers",
                "26.04.2012",
                "Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.",
                MovieGenre.ROMANCE,
                Person("Joss Whedon","23.06.1964"),
                listOf(Person("Robert Downey jr.","04.04.1965"),Person("Chris Evans","13.06.1981")),
                mutableListOf()
            ),
            Movie(
                "6",
                "Iron Man 3",
                "01.05.2013",
                "When Tony Stark's world is torn apart by a formidable terrorist called the Mandarin, he starts an odyssey of rebuilding and retribution.",
                MovieGenre.DRAMA,
                Person("Shane Black","16.12.1961"),
                listOf(Person("Robert Downey jr.","04.04.1965"),Person("Guy Pearce","05.10.1967")),
                mutableListOf()
            ),
            Movie(
                "7",
                "Thor: The Dark Kingdom",
                "31.10.2013",
                "When the Dark Elves attempt to plunge the universe into darkness, Thor must embark on a perilous and personal journey that will reunite him with doctor Jane Foster.",
                MovieGenre.HORROR,
                Person("Alan Taylor","19.10.1965"),
                listOf(Person("Chris Hemsworth","11.08.1983"),Person("Natalie Portman","09.06.1981")),
                mutableListOf()
            ),
            Movie(
                "8",
                "The Return of the First Avenger",
                "27.03.2014",
                "As Steve Rogers struggles to embrace his role in the modern world, he teams up with a fellow Avenger and S.H.I.E.L.D agent, Black Widow, to battle a new threat from history: an assassin known as the Winter Soldier.",
                MovieGenre.ACTION,
                Person("Anthony Russo","03.02.1970"),
                listOf(Person("Chris Evans","13.06.1981"),Person("Samuel L. Jackson","21.12.1948")),
                mutableListOf()
            ),
            Movie(
                "9",
                "Guardians of the Galaxy",
                "28.08.2014",
                "A group of intergalactic criminals must pull together to stop a fanatical warrior with plans to purge the universe.",
                MovieGenre.HORROR,
                Person("James Gunn","05.08.1966"),
                listOf(Person("Chris Pratt","21.06.1979"),Person("Vin Diesel","18.07.1967")),
                mutableListOf()
            ),
            Movie(
                "10",
                "Avengers: Age of Ultron",
                "23.04.2015",
                "When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it's up to Earth's mightiest heroes to stop the villainous Ultron from enacting his terrible plan.",
                MovieGenre.DRAMA,
                Person("Joss Whedon","23.06.1964"),
                listOf(Person("Robert Downey jr.","04.04.1965"),Person("Chris Evans","13.06.1981")),
                mutableListOf()
            ),
            Movie(
                "11",
                "Ant-Man",
                "23.07.2015",
                "Armed with a super-suit with the astonishing ability to shrink in scale but increase in strength, cat burglar Scott Lang must embrace his inner hero and help his mentor, Dr. Hank Pym, plan and pull off a heist that will save the world.",
                MovieGenre.COMEDY,
                Person("Peyton Reed","03.07.1964"),
                listOf(Person("Paul Rudd","06.04.1969"),Person("Michael Douglas","25.09.1944")),
                mutableListOf()
            ),
            Movie(
                "12",
                "The First Avenger: Civil War",
                "28.04.2016",
                "Political involvement in the Avengers' affairs causes a rift between Captain America and Iron Man.",
                MovieGenre.ACTION,
                Person("Anthony Russo","03.02.1970"),
                listOf(Person("Chris Evans","13.06.1981"),Person("Robert Downey jr.","04.04.1965")),
                mutableListOf()
            ),
            Movie(
                "13",
                "Doctor Strange",
                "27.10.2016",
                "While on a journey of physical and spiritual healing, a brilliant neurosurgeon is drawn into the world of the mystic arts.",
                MovieGenre.COMEDY,
                Person("Scott Derrickson","16.07.1966"),
                listOf(Person("Benedict Cumberbatch","19.07.1976"),Person("Chiwetel Ejiofor","10.07.1977")),
                mutableListOf()
            ),
            Movie(
                "14",
                "Guardians of the Galaxy Vol. 2",
                "27.04.2017",
                "The Guardians struggle to keep together as a team while dealing with their personal family issues, notably Star-Lord's encounter with his father the ambitious celestial being Ego.",
                MovieGenre.ROMANCE,
                Person("James Gunn","05.08.1966"),
                listOf(Person("Chris Pratt","04.04.1965"),Person("Zoe Saldana","18.06.1978")),
                mutableListOf()
            )
        )
    }
    fun moviesList(): List<Movie> {
        return movies
    }

    fun movieById(id: String): Movie? {
        return movies.find { it.id == id }
    }

    fun reviewMovie(id: String, review: Review) {
        val movie = movieById(id)
        movie?.reviews?.add(review)
    }
}