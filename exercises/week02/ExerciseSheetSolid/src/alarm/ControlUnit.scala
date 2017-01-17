package alarm

/**
  * Created by Alexander Worton on 17/01/2017.
  */
object ControlUnit {
  def main(args: Array[String]): Unit = {
    val sensor = new FireSensor("Hall")
    println("Battery: " + sensor.getBatteryPercentage)
    println("Type: " + sensor.getSensorType)
    println("Location: " + sensor.getLocation)
    println("Battery drain per poll: " + checkBatteryDrain(sensor) + "%")
    printf("Triggers: %.2f%%",checkTriggerPercentage(sensor))
  }

  def checkTriggerPercentage(sensor: Sensor): Double = {
    val range = 1 to 100000
    val triggers: Double = range.count(x => sensor.isTriggered)
    triggers / 1000
  }

  def checkBatteryDrain(sensor: Sensor): Double = {
    var i: Int = 0
    do {
      sensor.isTriggered
      i += 1
    } while(sensor.getBatteryPercentage > 0)
    100 / i
  }
}
