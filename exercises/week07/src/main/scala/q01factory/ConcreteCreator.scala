package factory

/**
  * Created by aworton on 21/02/17.
  */
class ConcreteCreator extends Creator{

  override def makeProduct(): Product = super.defaultProduct

  override def makeProduct(productType: String): Product = productType match {
    case "concrete" => new ConcreteProduct(0)
    case _ => super.defaultProduct
  }
}
