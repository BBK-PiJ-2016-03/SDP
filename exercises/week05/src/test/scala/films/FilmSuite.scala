package films

import org.scalatest.{BeforeAndAfter, FunSpec}

/**
  * Created by aworton on 18/02/17.
  */
class FilmSuite extends FunSpec with BeforeAndAfter{

  private val name = "The Hunt for Red October"
  private val yearOfRelease = 1990
  private val imdbRating = 7.6
  private val director = new Director("John", "McTiernan", 1951)
  private var film: Film = _

  before{
    film = new Film(name, yearOfRelease, imdbRating, director)
  }

  describe("Film"){
    it("should be created with a name, year of release, imdbRating and director"){
      assert(name == film.name)
      assert(yearOfRelease == film.yearOfRelease)
      assert(imdbRating == film.imdbRating)
      assert(director == film.director)
    }

    it("should return the age of the director at the time of release"){
      val roughAge = film.yearOfRelease - 1951
      assert(roughAge == film.directorsAge)
    }

    it("should accept a Director and determine whether the film is directed by them"){
      assert(true == film.isDirectedBy(director))
      assert(false == film.isDirectedBy(new Director("Christopher", "Nolan", 1970)))
    }

    it("should produce a copy of all non overridden attributes"){
      val someGuy = new Director("Just", "SomeGuy", 1990)
      assert(film == film.copy())
      assert(film == film.copy().copy())
      assert(film == film.copy().copy().copy())
      assert(film.copy(name = "Jaws") == new Film("Jaws", yearOfRelease, imdbRating, director))
      assert(film.copy(yearOfRelease = 1823) == new Film(name, 1823, imdbRating, director))
      assert(film.copy(imdbRating = 1.7) == new Film(name, yearOfRelease, 1.7, director))
      assert(film.copy(director = someGuy) == new Film(name, yearOfRelease, imdbRating, someGuy))
      assert(film.copy("Predator", 1987, 7.9, someGuy) == new Film("Predator", 1987, 7.9, someGuy))
    }
  }
}
