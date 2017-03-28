package q03interpreter

trait Expression {
  def gallons(quantity: Double): String

  def quarts(quantity: Double): String

  def pints(quantity: Double): String

  def cups(quantity: Double): String

  def tablespoons(quantity: Double): String
}
