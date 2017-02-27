package decorator

/**
  * Created by aworton on 27/02/17.
  */
class Cheese(pizza: Pizza) extends PizzaDecorator{
  override def getDesc: String = "Cheese"

  override def getPrice: Double = pizza.getPrice + 20.72
}
