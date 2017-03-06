package sml

import org.scalatest.{BeforeAndAfter, FunSpec}
import sml.library.LabelsFactory

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
    labels = LabelsFactory.populateLabels(label)
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

    it("should return its content when printed"){
      val register = 3
      instruction = LinInstruction(label, register, value)
      assert(s"$label: lin register $register value is $value\n" == instruction.toString())
    }
  }

}
