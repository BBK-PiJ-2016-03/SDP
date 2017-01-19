package alarm

/**
  * Created by Alexander Worton on 17/01/2017.
  */
class FireSensor (location: String) extends BatterySensor{

  def this() = this(null)

  override def isTriggered: Boolean = {
    drainBattery(10)
    r.nextInt(100) < 5
  }

  override def getLocation: String = location

  override def getSensorType: String = "Fire"

  override def getBatteryPercentage: Double = battery
}
