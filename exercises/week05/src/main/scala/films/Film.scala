package films

/**
  * Created by aworton on 18/02/17.
  */
case class Film(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) {
  def directorsAge = yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director) = director == this.director
}

object Film{

  def highestRating(film1: Film, film2: Film): Double = if(film1.imdbRating > film2.imdbRating) film1.imdbRating else film2.imdbRating

  def oldestDirectorAtTheTime(film1: Film, film2: Film): Director = {
    if(film1.yearOfRelease - film1.director.yearOfBirth > film2.yearOfRelease - film2.director.yearOfBirth)
      film1.director
    else
      film2.director
  }
}