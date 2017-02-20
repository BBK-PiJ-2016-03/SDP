package sml

/**
  * Created by aworton on 19/02/17.
  */
class SubInstruction (label: String, op: String, val result: Int, val op1: Int, val op2: Int)
  extends Instruction(label, op){

  def execute(m: Machine) {
    val value1 = m.regs(op1)
    val value2 = m.regs(op2)
    m.regs(result) = value1 - value2
  }

  override def toString(): String = {
    super.toString + " " + op1 + " - " + op2 + " to " + result + "\n"
  }
}

object SubInstruction {
  def apply(label: String, result: Int, op1: Int, op2: Int): SubInstruction =
    new SubInstruction(label, "sub", result, op1, op2)
}