package factory

/**
  * Created by aworton on 21/02/17.
  */
class ConcreteCreator() extends Creator{
  override def makeProduct(): Product = new ConcreteProduct(0)
}
