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
  private val director2 = new Director("Sam", "Smith", 1996)
  private var film: Film = _

  private var film2: Film = _

  before{
    film = new Film(name, yearOfRelease, imdbRating, director)
    film2 = new Film("Bleaugh", 2016, 0.1, director2)
  }

  describe("Film"){
    it("should take two films and return the oldest director at the time of shooting"){
      assert(director == Film.oldestDirectorAtTheTime(film, film2))
      assert(director == Film.oldestDirectorAtTheTime(film2, film))
    }

    it("should take two films and return the highest imdb of the two"){
      assert(imdbRating == Film.highestRating(film, film2))
      assert(imdbRating == Film.highestRating(film2, film))
    }

    it("should return a new film when applied"){
      assert(film == Film(name, yearOfRelease, imdbRating, director))
    }
  }

  describe("a film"){
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
      assert(film.isDirectedBy(director))
      assert(!film.isDirectedBy(new Director("Christopher", "Nolan", 1970)))
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
