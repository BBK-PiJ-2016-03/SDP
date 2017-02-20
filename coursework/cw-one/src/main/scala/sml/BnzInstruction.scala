package sml

/**
  * Created by aworton on 20/02/17.
  */
class BnzInstruction(label: String, op: String, val register: Int, val jump: String)
  extends Instruction(label, op){

  override def execute(m: Machine): Unit =  {
    if(m.regs(register) != 0) m.pc = m.labels.labels.indexOf(jump)
  }

  override def toString(): String = {
    super.toString + " jump to " + jump + " if " + register + " is not zero " + "\n"
  }
}

object BnzInstruction{
  def apply(label: String, result: Int, register: Int, jump: String): BnzInstruction =
    new BnzInstruction(label, "bnz", register, jump)
}