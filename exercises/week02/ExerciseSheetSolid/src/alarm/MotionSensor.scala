package alarm

/**
  * Created by Alexander Worton on 21/01/2017.
  */
class MotionSensor (location: String) extends SecuritySensor{
  override def isTriggered: Boolean = {
    r.nextInt(100) < 3
  }

  override def getLocation: String = location

  override def getSensorType: String = "Motion"
}
