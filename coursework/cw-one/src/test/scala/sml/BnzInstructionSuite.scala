package sml

import org.scalatest.{BeforeAndAfter, FunSpec}
import sml.library.LabelsFactory

/**
  * Created by aworton on 19/02/17.
  */
class BnzInstructionSuite extends FunSpec with BeforeAndAfter{

  private final val label0 = "f0"
  private final val label1 = "f1"
  private final val label2 = "f2"
  private final val label3 = "f3"
  private final var labels: Labels = _
  private var result = 2
  private val register1 = 1
  private val register2 = 2
  private val register3 = 3
  private val value1 = 3
  private val value2 = 1
  private val jump = "f2"
  private var machine: Machine = _
  private var loadR1Instruction: Instruction = _
  private var loadR2Instruction: Instruction = _
  private var subR3Instruction: Instruction = _
  val branchInstruction = BnzInstruction(label3, register3, jump)

  before{
    labels = LabelsFactory.populateLabels(label0, label1, label2, label3)
    loadR1Instruction = LinInstruction(label0, register1, value1)
    loadR2Instruction = LinInstruction(label1, register1, value2)
    subR3Instruction = SubInstruction(label2, register1, register1, register2)
  }

  describe("BnzInstruction"){
    it("should branch if the provided register is not zero"){
      machine = Machine(labels, Vector(loadR1Instruction, loadR2Instruction, subR3Instruction, branchInstruction))
      machine.execute()
      assert(machine.regs(register3) == 0)
    }

    it("should not branch if the provided register is zero"){
    }

    it("should return its content when printed"){
      val instruction = BnzInstruction(label2, register2, label0)
      assert(s"$label2: bnz jump to $label0 if $register2 is not zero\n" == instruction.toString())
    }
  }
}
