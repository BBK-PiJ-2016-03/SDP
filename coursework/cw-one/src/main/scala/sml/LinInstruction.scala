package sml

class LinInstruction(label: String, opcode: String, register: Int, value: Int) extends Instruction(label, opcode) {

  /**
    * Store integer value in register
    * @param m the virtual machine to operate on
    */
  override def execute(m: Machine): Unit =
    m.regs(register) = value

  /**
    * Represent the class in string format
    */
  override def toString(): String = {
    super.toString + " register " + register + " value is " + value + "\n"
  }
}

object LinInstruction {
  def apply(label: String, register: Int, value: Int): LinInstruction =
    new LinInstruction(label, "lin", register, value)
}