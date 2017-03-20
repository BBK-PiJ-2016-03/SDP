package q10bridge

/**
  * @author Alexander Worton.
  */
abstract class Car (product: Product, val name: String) {
  def produceProduct = {
    println(s"Producing ${product.productType}")
    println(s"Modifying product ${product.productType} according to ${name}")
  }
  def assemble = println(s"Assembling ${product.productType} for ${name}")
  def printDetails = println(s"Car: ${name}, Product: ${product.productType}")
}
