package decorator

/**
  * Created by aworton on 27/02/17.
  */
class Meat(pizza: Pizza) extends PizzaDecorator{
  override def getDesc: String = "Meat"

  override def getPrice: Double = pizza.getPrice + 14.25
}
