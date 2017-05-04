package state

case class RoboticOff(r: Robot) extends RoboticState {
  def walk(): Unit = ???
  def cook(): Unit = ???
  def off(): Unit = ???
}
