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
  private final val label4 = "f4"
  private final var labels: Labels = _
  private val register1 = 25
  private val register2 = 26
  private val register3 = 27
  private val value1 = 3
  private val value2 = 1
  private val value3 = 0
  private var machine: Machine = _
  private var loadR1Instruction: Instruction = _
  private var loadR2Instruction: Instruction = _
  private var subR3Instruction: Instruction = _
  private var branchInstruction: Instruction = _
  private val printInstruction = OutInstruction(label4, register1)

  before{
    labels = LabelsFactory.populateLabels(label0, label1, label2, label3, label4)
    loadR2Instruction = LinInstruction(label1, register2, value2)
  }

  describe("BnzInstruction"){
    it("should branch if the provided register is not zero"){
      loadR1Instruction = LinInstruction(label0, register1, value1)
      subR3Instruction = SubInstruction(label2, register1, register1, register2)
      branchInstruction = BnzInstruction(label3, register1, label2)

      machine = Machine(labels, Vector(loadR1Instruction, loadR2Instruction, subR3Instruction, branchInstruction, printInstruction))
      machine.execute()
      assert(machine.regs(register1) == 0)
    }

    it("should not branch if the provided register is zero"){
      loadR1Instruction = LinInstruction(label0, register1, value3)
      branchInstruction = BnzInstruction(label2, register1, label4)
      subR3Instruction = SubInstruction(label3, register1, register1, register2)

      machine = Machine(labels, Vector(loadR1Instruction, loadR2Instruction, branchInstruction, subR3Instruction, printInstruction))
      machine.execute()
      assert(machine.regs(register1) == value3 - 1)
    }

    it("should return its content when printed"){
      val instruction = BnzInstruction(label2, register2, label0)
      assert(s"$label2: bnz jump to $label0 if $register2 is not zero\n" == instruction.toString())
    }
  }
}
