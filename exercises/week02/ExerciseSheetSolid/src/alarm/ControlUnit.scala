package alarm

import scala.reflect.ClassTag

/**
  * Created by Alexander Worton on 17/01/2017.
  */
class ControlUnit {
  private var sensors: List[Sensor] = null

  def pollSensors = {
    //Responsibility: poll sensors
    for (sensor: Sensor <- sensors) {
      checkTriggered(sensor)
    }
  }

  def checkTriggered(sensor:Sensor) = {
    if (sensor.isTriggered)
      renderTrigger(sensor)
    else
      renderPolled(sensor)
  }

  //Responsibility: Render output
  def renderTrigger(sensor:Sensor) = System.out.println("A " + sensor.getSensorType + " sensor was triggered at " + sensor.getLocation)
  def renderPolled(sensor:Sensor) = System.out.println("Polled " + sensor.getSensorType + " at " + sensor.getLocation + " successfully")

  def getSensors: List[Sensor] = sensors
  def setSensors(sensorSet: List[Sensor]) = sensors = sensorSet

}
