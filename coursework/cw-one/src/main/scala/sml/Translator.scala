package sml

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {
  private final val ADD = "add"
  private final val LIN = "lin"
  private final val BNZ = "bnz"
  private final val MUL = "mul"
  private final val SUB = "sub"
  private final val OUT = "out"

  /**
    * translate the small program in the file into lab (the labels) and prog (the program)
    */
  def readAndTranslate(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog
    import scala.io.Source
    import scala.reflect.runtime.universe._
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      val fields = line.split(" ")
      if (fields.length > 0) {
        labels.add(fields(0))

        //locate class matching fields(1)
        //val instructionType = typeOf[Instruction].members.find(symbol => symbol.name.toString.indexOf(fields(1).capitalize) == 0)
        val instructionType = typeOf[Instruction].members.filter(symbol => {
          //println("Name: "+symbol.name.toString)
          symbol.name.toString.indexOf(fields(1).capitalize) == 0
        })

        println("BaseClasses")
        //typeOf[Instruction].

        //println(instructionType)

        if(instructionType.isEmpty){
          println(s"Unknown instruction ${fields(1)}")
        }
        else{
          //instantiate
          program = program :+ instructionType.getClass.getConstructors()(0).newInstance(fields).asInstanceOf[Instruction]
        }


      }
    }
    new Machine(labels, program)
  }
}

object Translator {
  def apply(file: String) = new Translator(file)
}
