package state

case class RoboticOn(r: Robot) extends RoboticState {
  def walk(): Unit = println("Walking...")
  def cook(): Unit = println("Cooking...")
  def off(): Unit = {
    println("Robot is switched off")
    r.state = r.roboticOff
  }
}
