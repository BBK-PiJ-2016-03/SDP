package films

/**
  * Created by aworton on 18/02/17.
  */
class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {
  def directorsAge = yearOfRelease - director.yearOfBirth
  def isDirectedBy(director: Director) = director == this.director

  def copy(name: String = this.name,
           yearOfRelease: Int = this.yearOfRelease,
           imdbRating: Double = this.imdbRating,
           director: Director = this.director) = {
    new Film(name, yearOfRelease, imdbRating, director)
  }

  override def equals(obj: Any) = obj match{
    case obj: Film => obj.name == this.name &&
      obj.yearOfRelease == this.yearOfRelease &&
      obj.imdbRating == this.imdbRating &&
      obj.director == this.director
    case _ => false
  }
}

object Film{
  def apply(name: String, yearOfRelease: Int, imdbRating: Double, director: Director): Film = new Film(name, yearOfRelease, imdbRating, director)
  def highestRating(film1: Film, film2: Film): Double = if(film1.imdbRating > film2.imdbRating) film1.imdbRating else film2.imdbRating
  def oldestDirectorAtTheTime(film1: Film, film2: Film): Director = {
    if(film1.yearOfRelease - film1.director.yearOfBirth > film2.yearOfRelease - film2.director.yearOfBirth)
      film1.director
    else
      film2.director
  }
}