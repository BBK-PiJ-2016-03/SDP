package state

case class RoboticOff(r: Robot) extends RoboticState {
  def walk(): Unit = println("Walking...")
  def cook(): Unit = println("Cannot cook at Off state.")
  def off(): Unit = println("Already in off state")
}
