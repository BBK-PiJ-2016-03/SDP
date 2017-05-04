package state

case class RoboticOn(r: Robot) extends RoboticState {
  def walk(): Unit = ???
  def cook(): Unit = ???
  def off(): Unit = ???
}
