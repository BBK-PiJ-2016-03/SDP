package q03interpreter

/**
  * @author Alexander Worton.
  */
class Subtract(private val leftExpression: Expression,
               private val rightExpression: Expression)
  extends Expression {
    override def interpret(): Int =
      leftExpression.interpret() - rightExpression.interpret()
  }
