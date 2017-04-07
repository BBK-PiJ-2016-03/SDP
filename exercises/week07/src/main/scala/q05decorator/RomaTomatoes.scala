package decorator

/**
  * Created by aworton on 27/02/17.
  */
class RomaTomatoes(pizza: Pizza) extends PizzaDecorator{
  override def getDesc: String = "Roma Tomatoes"

  override def getPrice: Double = pizza.getPrice + 5.20
}
