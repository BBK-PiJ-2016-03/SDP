package decorator

/**
  * Created by aworton on 27/02/17.
  */
class GreenOlives(pizza: Pizza) extends PizzaDecorator{
  override def getDesc: String = "Green Olives"

  override def getPrice: Double = pizza.getPrice + 5.47
}
