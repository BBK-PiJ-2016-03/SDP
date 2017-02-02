package alarm.sensors

import alarm.BatterySensor

/**
  * Created by Alexander Worton on 17/01/2017.
  */
class SmokeSensor(location: String) extends BatterySensor {

  def this() = this(null)

  override def isTriggered: Boolean = {
    drainBattery(20)
    r.nextInt(100) < 10
  }

  override def getLocation: String = location

  override def getSensorType: String = "Smoke"

  override def getBatteryPercentage: Double = battery
}
