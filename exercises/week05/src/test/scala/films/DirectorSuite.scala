package films

import org.scalatest.{BeforeAndAfter, FunSpec}

/**
  * Created by aworton on 18/02/17.
  */
class DirectorSuite extends FunSpec with BeforeAndAfter{

  private val firstName = "John"
  private val lastName = "Candy"
  private val yearOfBirth = 1950
  private var director: Director = _

  private val yearOfBirth2 = 1920
  private var director2: Director = _

  before{
    director = new Director(firstName, lastName, yearOfBirth)
  }

  describe("Director"){
    it("should take two directors and return the oldest of the two"){
      director2 = new Director(firstName, lastName, yearOfBirth2)
      assert(director2 == Director.older(director, director2))
      assert(director2 == Director.older(director2, director))
    }

    it("should return a new director when applied"){
      assert(director == Director(firstName, lastName, yearOfBirth))
    }
  }

  describe("a Director"){
    it("should be created with a first name, last name and year of birth"){
      assert(firstName == director.firstName)
      assert(lastName == director.lastName)
      assert(yearOfBirth == director.yearOfBirth)
    }

    it("should be able to return the full name from name"){
      assert(firstName+" "+lastName == director.name)
    }
  }

}
