package sml

import org.scalatest.{BeforeAndAfter, FunSpec}

/**
  * Created by aworton on 06/03/17.
  */
class TranslatorSuite extends FunSpec with BeforeAndAfter{

  private var machine: Machine = _
  private val prog1Result = 66 + 66
  private val prog1Register = 10

  before{
    machine = Machine(Labels(), Vector())
  }

  describe("translator"){
    it("should take a file path and return a machine holding the parsed data"){
      val translator = Translator("programs/test1.sml")
      val parsedMachine = translator.readAndTranslate(machine)
      assert(parsedMachine.pc == 0)
      assert(parsedMachine.regs.registers.forall(value => value == 0))
      parsedMachine.execute()
      assert(parsedMachine.regs.registers(prog1Register) == prog1Result)
    }

    it("should throw an UnknownInstructionException when attempting to parse an unknown instruction"){
      assertThrows[UnknownInstructionException]{
        Translator("programs/test4-unknown-instructions.sml").readAndTranslate(machine)
      }
    }

    it("should throw an IllegalArgumentException if the wrong number of arguments are provided"){
      assertThrows[IllegalArgumentException]{
        Translator("programs/test5-incorrect-args.sml").readAndTranslate(machine)
      }
    }
  }
}
