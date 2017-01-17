package alarm

import scala.util.Random

/**
  * Created by Alexander Worton on 17/01/2017.
  */
abstract class BatterySensor extends Sensor{
  protected var battery: Double = 100
  val r = new Random

  protected def drainBattery(i: Double) = {
    if(battery - i < 0)
      battery = 0
    else
      battery -= i
  }

}
