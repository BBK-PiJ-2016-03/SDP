package sml

/**
  * Created by aworton on 20/02/17.
  */
class BnzInstruction(label: String, op: String, val register: Int, val jump: String)
  extends Instruction(label, op){

  /**
    * If the contents of register is not zero, then make jump the next instruction to execute
    * @param m the virtual machine to operate on
    */
  override def execute(m: Machine): Unit =  {
    if(m.regs(register) != 0) m.pc = m.labels.labels.indexOf(jump)
  }

  /**
    * Represent the class in string format
    */
  override def toString(): String = {
    super.toString + " jump to " + jump + " if " + register + " is not zero" + "\n"
  }
}

/**
  * Companion object
  */
object BnzInstruction{
  def apply(label: String, register: Int, jump: String): BnzInstruction =
    new BnzInstruction(label, "bnz", register, jump)
}