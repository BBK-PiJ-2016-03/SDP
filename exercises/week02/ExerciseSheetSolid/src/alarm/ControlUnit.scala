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

    var i: Int = 0
    do {
      sensor.isTriggered
      i += 1
    }while(sensor.getBatteryPercentage > 0)

    println("Battery drain per poll: " + (100 / i) + "%")

    val range = 1 to 100000

    val triggers: Double = range.count(x => sensor.isTriggered)
    val triggerPercentage: Double = triggers / 1000

    println("Triggers: " + triggerPercentage + "%")

  }
}
