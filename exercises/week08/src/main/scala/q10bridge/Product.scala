package q10bridge

/**
  * @author Alexander Worton.
  */
abstract class Product (val productType: String) {
  def produce(car: Car): String = "Modifying product " + productType + "according to " + car.name
}
