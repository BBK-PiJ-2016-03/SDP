package q06mediator

class Motor {

  def startMotor(): Unit = println("Start motor...")

  def rotateDrum(rpm: Int): Unit = println(s"Rotating drum at $rpm rpm.")
}