package sml

import org.scalatest.{BeforeAndAfter, FunSpec}

/**
  * Created by aworton on 19/02/17.
  */
class LinInstructionSuite extends FunSpec with BeforeAndAfter{

  private var instruction: LinInstruction = _
  private var machine: Machine = _
  private var labels: Labels = _
  private val label = "f0"
  private final val value = 6

  before{
    labels = new Labels
    labels.add(label)
  }

  describe("LinInstruction"){
    it("should write a given value to a specified memory location"){
      (0 to 31).foreach(register => {
        instruction = LinInstruction(label, register, value)
        machine = Machine(labels, Vector(instruction))
        machine.execute()
        assert(machine.regs(register) == value)
      })
    }
  }

}
