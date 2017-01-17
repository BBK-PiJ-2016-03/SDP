package alarm

import scala.reflect.ClassTag

/**
  * Created by Alexander Worton on 17/01/2017.
  */
class ControlUnit {
  def main(args: Array[String]): Unit = {
//    printSensorData(new FireSensor("Hall"), new FireSensor("Hall"))
//    printSensorData(new SmokeSensor("Living Room"), new SmokeSensor("Living Room"))
  }

  def pollSensors = {
    //Responsibility: Populate sensor list
    val sensors: List[Sensor] = List(new FireSensor, new SmokeSensor)

    //Responsibility: poll sensors
    for (sensor: Sensor <- sensors) {
      if (sensor.isTriggered)
        //Responsibility: Render output
        System.out.println("A " + sensor.getSensorType + " sensor was triggered at " + sensor.getLocation);
      else
        //Responsibility: Render output
        System.out.println("Polled " + sensor.getSensorType + " at " + sensor.getLocation + " successfully");
    }
  }

//  def printSensorData(sensor: Sensor, sensor2: Sensor) = {
//    println("Battery: " + sensor.getBatteryPercentage)
//    println("Type: " + sensor.getSensorType)
//    println("Location: " + sensor.getLocation)
//    println("Battery drain per poll: " + checkBatteryDrain(sensor) + "%")
//    printf("Triggers: %.2f%%", checkTriggerPercentage(sensor2))
//    println
//    println
//  }
//
//  def checkTriggerPercentage(sensor: Sensor): Double = {
//    val range = 1 to 1000000
//    val triggers: Double = range.count(x => sensor.isTriggered)
//    triggers / 10000
//  }
//
//  def checkBatteryDrain(sensor: Sensor): Double = {
//    var i: Int = 0
//    do {
//      sensor.isTriggered
//      i += 1
//    } while(sensor.getBatteryPercentage > 0)
//    100 / i
//  }
}
