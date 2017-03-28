package q03interpreter

final case class Cups() extends Expression {
  override def gallons(quantity: Double) = (quantity / 16).toString

  override def quarts(quantity: Double) = (quantity / 4).toString

  override def pints(quantity: Double) = (quantity / 2).toString

  override def cups(quantity: Double) = quantity.toString

  override def tablespoons(quantity: Double) = (quantity * 16).toString
}
