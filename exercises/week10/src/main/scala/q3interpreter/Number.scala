package q3interpreter

/**
  * @author Alexander Worton.
  */
class Number(private val number: Int) extends Expression{

  override def interpret(): Int = number
}
