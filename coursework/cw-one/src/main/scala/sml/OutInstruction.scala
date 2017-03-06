package sml

/**
  * Created by aworton on 20/02/17.
  */
class OutInstruction(label: String, op: String, val register: Int)
  extends Instruction(label, op){

  /**
    * Print the contents of register on the Java console (using println)
    * @param m the virtual machine to operate on
    */
  override def execute(m: Machine): Unit =  {
    println(m.regs(register))
  }

  /**
    * Represent the class in string format
    */
  override def toString(): String = {
    super.toString + " " + register + " output to console" + "\n"
  }
}

object OutInstruction{
  def apply(label: String, register: Int): OutInstruction =
    new OutInstruction(label, "out", register)
}

