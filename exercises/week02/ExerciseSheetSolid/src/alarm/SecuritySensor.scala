package alarm

import scala.util.Random

/**
  * Created by Alexander Worton on 21/01/2017.
  */
trait SecuritySensor extends Sensor{
  val r = new Random
}
