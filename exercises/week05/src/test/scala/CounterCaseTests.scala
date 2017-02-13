package week05

import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import org.scalatest
/**
  * Created by Alexander Worton on 13/02/2017.
  */
class CounterCaseTests extends FunSpec with BeforeAndAfter{

  private var counter:CounterCase = _

  before{
    counter = new CounterCase
  }

  describe("a CounterCase"){

    it("should start with 0 value"){
      assert(counter.count == 0)
    }

    it("should be incrementable"){
      assert(counter.inc().count == 1)
    }

    it("should be decrementable"){
      assert(counter.dec().count == -1)
    }

    it("should be incrementable by a specified amount"){
      (1 to 50).foreach(i => {
        assert(counter.inc(i).count == i)
      })
    }

    it("should be decrementable by a specified amount"){
      (1 to 50).foreach(i => {
        assert(counter.dec(i).count == -i)
      })
    }

    it("should be incrementable and decrementable in a chain"){
      (1 to 50).foreach(i => {
        assert(counter.inc(i).dec(i).count == 0)
      })
    }
  }
}
