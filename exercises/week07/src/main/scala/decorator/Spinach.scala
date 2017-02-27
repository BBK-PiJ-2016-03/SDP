package decorator

/**
  * Created by aworton on 27/02/17.
  */
class Spinach(pizza: Pizza) extends PizzaDecorator{
  override def getDesc: String = "Spinach"

  override def getPrice: Double = pizza.getPrice + 7.92
}
