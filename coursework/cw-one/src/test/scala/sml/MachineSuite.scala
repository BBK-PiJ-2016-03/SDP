package sml

import org.scalatest.{BeforeAndAfter, FunSpec}

/**
  * Created by aworton on 19/02/17.
  */
class MachineSuite extends FunSpec with BeforeAndAfter{

  private val machine: Machine = Machine(Labels(), Vector())

  describe("Machine"){

    it("should start with empty registers"){
      (0 to 31).foreach(register => {
        assert(machine.regs(register) == 0)
      })
    }
  }

}
