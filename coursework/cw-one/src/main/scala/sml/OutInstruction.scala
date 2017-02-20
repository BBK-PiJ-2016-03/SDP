package sml

/**
  * Created by aworton on 20/02/17.
  */
class OutInstruction(label: String, op: String, val register: Int)
  extends Instruction(label, op){

  override def execute(m: Machine): Unit =  {
    println(m.regs(register))
  }

  override def toString(): String = {
    super.toString + " " + register + " output to console" + "\n"
  }
}

object OutInstruction{
  def apply(label: String, register: Int): OutInstruction =
    new OutInstruction(label, "out", register)
}

