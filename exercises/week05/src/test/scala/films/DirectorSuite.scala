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

  before{
    director = new Director(firstName, lastName, yearOfBirth)
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
