package factory

/**
  * Created by aworton on 21/02/17.
  */
trait Creator {
  def makeProduct: Product

  def makeProduct(productType: String): Product

  def defaultProduct: Product = new defaultProduct

  private class defaultProduct extends Product
}
