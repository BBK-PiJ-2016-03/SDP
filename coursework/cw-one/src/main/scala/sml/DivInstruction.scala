package sml

/**
  * Created by aworton on 20/02/17.
  */
class DivInstruction(label: String, op: String, val result: Int, val op1: Int, val op2: Int)
  extends Instruction(label, op){

  /**
    * Divide (Java integer division) the contents of register op1 by the contents
    * of register op2 and store the result in register result
    * @param m the virtual machine to operate on
    */
  override def execute(m: Machine): Unit =  {
    val value1 = m.regs(op1)
    val value2 = m.regs(op2)
    m.regs(result) = value1 / value2
  }

  /**
    * Represent the class in string format
    */
  override def toString(): String = {
    super.toString + " " + op1 + " / " + op2 + " to " + result + "\n"
  }
}

object DivInstruction{
  def apply(label: String, result: Int, op1: Int, op2: Int): DivInstruction =
    new DivInstruction(label, "div", result, op1, op2)
}
