package state

case class RoboticCook(r: Robot) extends RoboticState {
  def walk(): Unit = ???
  def cook(): Unit = ???
  def off(): Unit = ???
}
