package library

import alarm.{FireSensor, MotionSensor, Sensor, SmokeSensor}

/**
  * Created by Alexander Worton on 19/01/2017.
  */
object Populate {
  def getHazardSensors: List[Sensor] = {
    return (1 to 5).toStream
      .flatMap(i => (new FireSensor("Unknown") :: new SmokeSensor("Unknown") :: Nil))
      .toList
  }

  def getSecuritySensors: List[Sensor] = {
    return (1 to 5).toStream
      .flatMap(i => (new MotionSensor("Unknown") :: new MotionSensor("Unknown") :: Nil))
      .toList
  }


}
