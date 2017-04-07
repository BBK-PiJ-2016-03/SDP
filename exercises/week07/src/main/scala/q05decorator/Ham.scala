package decorator

/**
  * Created by aworton on 27/02/17.
  */
class Ham(pizza: Pizza) extends PizzaDecorator{
  override def getDesc: String = "Ham"

  override def getPrice: Double = pizza.getPrice + 18.12
}