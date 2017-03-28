package q03interpreter

final case class Gallons() extends Expression {
  override def gallons(quantity: Double) = String.valueOf(quantity)

  override def quarts(quantity: Double) = String.valueOf(quantity * 4)

  override def pints(quantity: Double) = String.valueOf(quantity * 8)

  override def cups(quantity: Double) = String.valueOf(quantity * 16)

  override def tablespoons(quantity: Double) = String.valueOf(quantity * 256)
}
