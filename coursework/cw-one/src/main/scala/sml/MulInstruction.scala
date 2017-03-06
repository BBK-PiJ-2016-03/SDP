package sml

/**
  * Created by aworton on 20/02/17.
  */
class MulInstruction(label: String, op: String, val result: Int, val op1: Int, val op2: Int)
  extends Instruction(label, op){

  /**
    * Multiply the contents of registers op1 and op2 and store the result in
    * register result
    * @param m the virtual machine to operate on
    */
  override def execute(m: Machine): Unit =  {
    val value1 = m.regs(op1)
    val value2 = m.regs(op2)
    m.regs(result) = value1 * value2
  }

  /**
    * Represent the class in string format
    */
  override def toString(): String = {
    super.toString + " " + op1 + " * " + op2 + " to " + result + "\n"
  }
}

object MulInstruction{
  def apply(label: String, result: Int, op1: Int, op2: Int): MulInstruction =
    new MulInstruction(label, "mul", result, op1, op2)
}

