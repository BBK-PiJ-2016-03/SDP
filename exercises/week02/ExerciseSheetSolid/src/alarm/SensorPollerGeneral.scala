package alarm

/**
  * Created by Alexander Worton on 19/01/2017.
  */
class SensorPollerGeneral (renderer: Renderer) extends SensorPoller{
  override def poll(sensors: List[Sensor]): Unit = {
    sensors.foreach(s => checkTriggered(s))
  }

  def checkTriggered(sensor:Sensor) = {
    if (sensor.isTriggered)
      renderer.renderTrigger(sensor)
    else
      renderer.renderPolled(sensor)
  }
}
