package sml

/**
  * Created by aworton on 19/02/17.
  */
class SubInstruction (label: String, op: String, val result: Int, val op1: Int, val op2: Int)
  extends Instruction(label, op){

  /**
    * Subtract the contents of register op2 from the contents of op1 and store
    * the result in register result
    * @param m the virtual machine to operate on
    */
  def execute(m: Machine) {
    val value1 = m.regs(op1)
    val value2 = m.regs(op2)
    m.regs(result) = value1 - value2
  }

  /**
    * Represent the class in string format
    */
  override def toString(): String = {
    s"${super.toString} $op1 - $op2 to $result\n"
  }
}

object SubInstruction {
  def apply(label: String, result: Int, op1: Int, op2: Int): SubInstruction =
    new SubInstruction(label, "sub", result, op1, op2)
}