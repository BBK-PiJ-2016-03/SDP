package sml

import scala.io.Source

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {

  /**
    * translate the small program in the file into lab (the labels) and prog (the program)
    */
  def readAndTranslate(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog

    val lines = Source.fromFile(fileName).getLines.foreach(line => {
      val fields = line.split(" ")
      addLabel(fields, labels)

      val arguments: Array[AnyRef] = getArgumentsFromFields(fields)
      val instructionInstance = instantiateInstructionClass(getInstructionName(fields), arguments)

      if(instructionInstance != None) {
        program = addInstructionToProgram(instructionInstance.get, program, getInstructionName(fields))
      }
      else{
        println(s"Unknown instruction ${getInstructionName(fields)}")
      }
    })

    new Machine(labels, program)
  }

  /**
    * processor to return the instruction name from the unprocessed fields
    * @param fields the unprocessed fields from the instruction string
    * @return the name of the instruction, located at the second position
    */
  private def getInstructionName(fields: Array[String]): String = fields(1)

  /**
    * add the label to the labels collection
    * @param fields the array of strings holding the fields
    * @param labels the labels component of the machine
    */
  private def addLabel(fields: Array[String], labels: Labels): Labels = {
    if (fields.length > 0){
      labels.add(fields(0))
    }
    labels
  }

  /**
    * convert all the fields after the first two to int if they canbe, else leave them as string
    * as these are the only two types of argument supported. This covers thr BNZ type as well as
    * all the other instructions.
    * @param fields the unprocessed arguments
    * @return an array of AnyRef holding the type processed arguments
    */
  private def getArgumentsFromFields(fields: Array[String]): Array[AnyRef] = {
    if(fields.length > 2) {
      ((fields.splitAt(2)_1) ++ ((fields.splitAt(2)_2)).map(argument => {
        try {
          argument.toInt
        }
        catch{
          case e: NumberFormatException => argument
        }
      })).asInstanceOf[Array[AnyRef]]
    }
    else {
      Array()
    }
  }

  /**
    * instantiate and return the instantiated class matching the instruction as an option
    * return none if the class could not be instantiated
    * @param arguments the arguments for the constructor
    * @return an option containing the instantiated class
    */
  private def instantiateInstructionClass(instructionName: String, arguments: Array[AnyRef]): Option[Instruction] = {
    try {
      val instructionType = Class.forName(getInstructionClassName(instructionName))
      Some(instructionType.getConstructors()(0).newInstance(arguments:_*).asInstanceOf[Instruction])
    }
    catch{
      case e: ClassNotFoundException => None
      case e: IllegalArgumentException => {
        println("Wrong number of arguments: ")
        arguments.foreach(arg => println(arg))
        None
      }
      case e: ClassCastException => {
        print(instructionName + " found, but is not an Instruction: ")
        None
      }
    }
  }

  /**
    * add the known instruction to the program
    * @param instructionInstance the instantiated instruction class
    * @param program the existing Vector of instructions
    * @param instruction the name of the instruction being added
    */
  private def addInstructionToProgram(instructionInstance: Instruction, program: Vector[Instruction], instruction: String): Vector[Instruction] = {
    val updatedProgram = program :+ instructionInstance
    updatedProgram
  }

  /**
    * get the qualified class name for the instruction
    * @param instructionHandle the identifier for the instruction
    * @return the qualified class name
    */
  private def getInstructionClassName(instructionHandle: String): String = "sml." + instructionHandle.capitalize + "Instruction"
}

object Translator {
  def apply(file: String) = new Translator(file)
}
