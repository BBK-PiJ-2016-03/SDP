package sml

import org.scalatest.{BeforeAndAfter, FunSpec}
import sml.library.LabelsFactory

/**
  * Created by aworton on 19/02/17.
  */
class OutInstructionSuite extends FunSpec with BeforeAndAfter{

  private var load: Instruction = _
  private var out: Instruction = _
  private var machine: Machine = _
  private var labels: Labels = _
  private val label0 = "f0"
  private val label1 = "f1"
  private final val register = 6

  before{
    labels = LabelsFactory.populateLabels(label0, label1)
  }

  describe("OutInstruction"){
    it("should print the contents of register on the Java console"){
      val start = -1000
      val end = 1000
      (start to end).foreach(value => {
        load = LinInstruction(label0, register, value)
        out = OutInstruction(label1, register)
        machine = Machine(labels, Vector(load, out))
        machine.execute()
        assert(Console.lastPrint == value)
      })
    }
  }

}
