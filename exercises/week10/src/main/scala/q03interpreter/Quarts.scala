package q03interpreter

final case class Quarts() extends Expression {
  override def gallons(quantity: Double) = (quantity / 4).toString

  override def quarts(quantity: Double) = (quantity).toString

  override def pints(quantity: Double) = (quantity * 2).toString

  override def cups(quantity: Double) = (quantity * 4).toString

  override def tablespoons(quantity: Double): String = (quantity * 64).toString
}
