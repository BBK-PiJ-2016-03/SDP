package sml

/**
  * Created by aworton on 19/02/17.
  */
class SubInstruction(label: String, op: String, override val result: Int, override val op1: Int, override val op2: Int)
  extends AddInstruction(label, op, result, op1, op2){

  override def execute(m: Machine) {
    val value1 = m.regs(op1)
    val value2 = m.regs(op2)
    m.regs(result) = value1 - value2
  }
}

object SubInstruction {
  def apply(label: String, result: Int, op1: Int, op2: Int): SubInstruction =
    new SubInstruction(label, "sub", result, op1, op2)
}