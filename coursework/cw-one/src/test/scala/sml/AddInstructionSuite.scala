package sml

import org.scalatest.{BeforeAndAfter, FunSpec}

/**
  * Created by aworton on 19/02/17.
  */
class AddInstructionSuite extends FunSpec with BeforeAndAfter{

  private var instruction: AddInstruction = _
  private var loadR2Instruction: LinInstruction = _
  private var loadR3Instruction: LinInstruction = _
  private var machine: Machine = _
  private var labels: Labels = _
  private val label0 = "f0"
  private val label1 = "f1"
  private val label2 = "f2"
  private final val increase = 10
  private final val register0 = 0
  private final val register1 = 1
  private final val register2 = 2

  before{
    labels = new Labels
    labels.add(label0)
    labels.add(label1)
    labels.add(label2)
    loadR3Instruction = LinInstruction(label1, register2, increase)
  }

  describe("AddInstruction"){

    it("should take two values and return the sum of them"){

      (1 to 1000).foreach(valueR2 => {
        loadR2Instruction = LinInstruction(label0, register1, valueR2)
        instruction = AddInstruction(label2, register0, register1, register2)
        machine = Machine(labels, Vector(loadR2Instruction, loadR3Instruction, instruction))
        machine.execute()
        assert(machine.regs(register0) == (valueR2 + increase))
      })

    }
  }

}
