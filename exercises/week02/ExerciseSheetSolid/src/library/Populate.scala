package library

import alarm.Sensor
import alarm.FireSensor
import alarm.SmokeSensor

/**
  * Created by Alexander Worton on 19/01/2017.
  */
object Populate {
  def getSensors: List[Sensor] = {
    return (1 to 5).toStream
      .flatMap(i => (new FireSensor("Unknown") :: new SmokeSensor("Unknown") :: Nil))
      .toList
  }


}
