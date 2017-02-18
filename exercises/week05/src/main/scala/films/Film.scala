package films

import java.time.LocalDate

/**
  * Created by aworton on 18/02/17.
  */
class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {
  def directorsAge = LocalDate.now().getYear - director.yearOfBirth
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