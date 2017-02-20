package sml

import org.scalatest.{BeforeAndAfter, FunSpec}

/**
  * Created by aworton on 19/02/17.
  */
class SubInstructionSuite extends FunSpec with BeforeAndAfter{

  private var instruction: SubInstruction = _
  private var loadR2Instruction: LinInstruction = _
  private var loadR3Instruction: LinInstruction = _
  private var machine: Machine = _
  private var labels: Labels = _
  private final val label0 = "f0"
  private final val label1 = "f1"
  private final val label2 = "f2"
  private final val decrease = 10
  private final val register0 = 0
  private final val register1 = 1
  private final val register2 = 2

  before{
    labels = new Labels
    labels.add(label0)
    labels.add(label1)
    labels.add(label2)
    loadR3Instruction = LinInstruction(label1, register2, decrease)
  }

//  describe("SubInstruction"){
//
//    it("should take two values and return the result of subtracting the second from the first"){
//      val start = -1000
//      val end = 1000
//
//      (start to end by 2).foreach(valueR2 => {
//        loadR2Instruction = LinInstruction(label0, register1, valueR2)
//        instruction = SubInstruction(label2, register0, register1, register2)
//        machine = Machine(labels, Vector(loadR2Instruction, loadR3Instruction, instruction))
//        machine.execute()
//        assert(machine.regs(register0) == (valueR2 - decrease))
//      })
//
//    }
//  }

}

