package decorator

/**
  * Created by aworton on 27/02/17.
  */
class SimplyNonVegPizza extends Pizza{

  override def getDesc: String = "SimplyNonVegPizza"

  override def getPrice: Double = 350
}
