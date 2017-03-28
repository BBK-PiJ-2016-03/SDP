package q3interpreter

/**
  * @author Alexander Worton.
  */
object ExpressionUtils {
  def isOperator(token: String): Boolean = token match {
    case "+" => true
    case "*" => true
    case "-" => true
    case _ => false
  }

  def getOperator(s: String, leftExpression: Expression, rightExpression: Expression): Expression = s match {
    case "+" => new Add(leftExpression, rightExpression)
    case "*" => new Product(leftExpression, rightExpression)
    case "-" => new Subtract(leftExpression, rightExpression)
  }
}
