package q03interpreter

final case class Tablespoons() extends Expression {
  override def gallons(quantity: Double): String = String.valueOf(quantity / 256)

  override def quarts(quantity: Double): String = String.valueOf(quantity / 64)

  override def pints(quantity: Double): String = String.valueOf(quantity / 32)

  override def cups(quantity: Double): String = String.valueOf(quantity / 16)

  override def tablespoons(quantity: Double): String = String.valueOf(quantity)
}
