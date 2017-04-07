package factory

/**
  * Created by aworton on 21/02/17.
  */
trait Product {

  private var price: Double = 0

  def getPrice(): Double = price

  def setPrice(newPrice: Double): Unit = price = newPrice
}
