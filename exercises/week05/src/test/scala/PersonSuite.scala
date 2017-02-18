import org.scalatest.FunSpec

/**
  * Created by aworton on 18/02/17.
  */
class PersonSuite extends FunSpec{

  describe("a Person"){
    it("should be created with an accessible first and second name"){
      val firstName = "Bob"
      val surName = "Tabor"
      val person = new Person(firstName, surName)
      assert(person.first == firstName)
      assert(person.last == surName)
    }

    it("should be creatable using a single string from the companion object"){
      val firstName = "Bob"
      val surName = "Tabor"
      val person = Person(firstName+" "+surName)
      assert(person.first == firstName)
      assert(person.last == surName)
    }
  }
}
