package sml

import org.scalatest.{BeforeAndAfter, FunSpec}
import sml.library.LabelsFactory

/**
  * Created by aworton on 19/02/17.
  */
class DivInstructionSuite extends FunSpec with BeforeAndAfter{

  private var instruction: DivInstruction = _
  private var loadR1Instruction: LinInstruction = _
  private var loadR2Instruction: LinInstruction = _
  private var machine: Machine = _
  private var labels: Labels = _
  private final val label0 = "f0"
  private final val label1 = "f1"
  private final val label2 = "f2"
  private final val source = 10000
  private final val register0 = 0
  private final val register1 = 1
  private final val register2 = 2

  before{
    labels = LabelsFactory.populateLabels(label0, label1, label2)
    loadR1Instruction = LinInstruction(label1, register1, source)
  }

  describe("DivInstruction"){
    it("should take three registers and write the result of dividing the second with the third into the first") {
      val start = -999
      val end = 1001

      (start to end by 2).foreach(valueR2 => {
        loadR2Instruction = LinInstruction(label0, register2, valueR2)
        instruction = DivInstruction(label2, register0, register1, register2)
        machine = Machine(labels, Vector(loadR1Instruction, loadR2Instruction, instruction))
        machine.execute()
        assert(machine.regs(register0) == (source / valueR2))
      })
    }

    it("should throw a DivisionByZero exception if a division by zero is attempted") {
      assertThrows[ArithmeticException] {
        loadR2Instruction = LinInstruction(label0, register2, 0)
        instruction = DivInstruction(label2, register0, register1, register2)
        machine = Machine(labels, Vector(loadR1Instruction, loadR2Instruction, instruction))
        machine.execute()
      }
    }

    it("should return its content when printed"){
      instruction = DivInstruction(label0, register0, register1, register2)
      assert(s"$label0: div $register1 / $register2 to $register0\n" == instruction.toString())
    }
  }
}
