package state

case class RoboticStandby(r: Robot) extends RoboticState {
  def walk(): Unit = ???
  def cook(): Unit = ???
  def off(): Unit = ???
}
