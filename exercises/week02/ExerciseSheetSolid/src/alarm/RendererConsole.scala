package alarm

/**
  * Created by Alexander Worton on 19/01/2017.
  */
class RendererConsole extends Renderer{
  override def renderTrigger(sensor:Sensor) = System.out.println("A " + sensor.getSensorType + " sensor was triggered at " + sensor.getLocation)
  override def renderPolled(sensor:Sensor) = System.out.println("Polled " + sensor.getSensorType + " at " + sensor.getLocation + " successfully")
}
