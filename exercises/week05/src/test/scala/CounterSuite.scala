package week05

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
/**
  * Created by Alexander Worton on 13/02/2017.
  */
class CounterSuite extends FunSuite with BeforeAndAfter{

  private var counter:Counter = _

  before{
    counter = new Counter()
  }

  test("counter initialises to 0"){
    assert(counter.count == 0)
  }

  test("incrementing without parameter by 1"){
    assert(counter.inc().count == 1)
  }

  test("decrementing without parameter by 1"){
    assert(counter.dec().count == -1)
  }

  test("incrementing with parameter"){
    (1 to 50).foreach(i => {
      assert(counter.inc(i).count == i)
    })
  }

  test("decrementing with parameter"){
    (1 to 50).foreach(i => {
      assert(counter.dec(i).count == -i)
    })
  }

  test("incrementing and decrementing with parameter"){
    (1 to 50).foreach(i => {
      assert(counter.inc(i).dec(i).count == 0)
    })
  }

  test("adjust applies a supplied adder"){
    (1 to 100 by 2).foreach(i => {
      assert(counter.adjust(new Adder(i)).count == i)
    })
  }

}
