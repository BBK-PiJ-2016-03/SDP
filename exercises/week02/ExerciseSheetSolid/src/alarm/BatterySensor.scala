package alarm

import scala.util.Random

/**
  * Created by Alexander Worton on 17/01/2017.
  */
abstract class BatterySensor extends Sensor{
  /**
    *
    * @return the remaining charge in the battery
    */
  def getBatteryPercentage: Double

  protected var battery: Double = 100
  val r = new Random

  /**
    * handles draining the battery by a specified value
    * @param drainAmount
    */
  protected def drainBattery(drainAmount: Double) = {
    if(battery - drainAmount < 0)
      battery = 0
    else
      battery -= drainAmount
  }

}
