package q6builder

/**
  * @author Alexander Worton.
  */
trait CarBuilder {

  var car:Car

  def buildBody: CarBuilder

  def buildPower: CarBuilder

  def buildEngine: CarBuilder

  def buildBrakes: CarBuilder

  def buildSeats: CarBuilder

  def buildWindows: CarBuilder

  def buildFuelType: CarBuilder

  def getCar: Car = car
}
