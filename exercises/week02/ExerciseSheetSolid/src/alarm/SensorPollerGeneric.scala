package alarm

/**
  * Created by Alexander Worton on 19/01/2017.
  */
class SensorPollerGeneric(renderer: Renderer) extends SensorPoller{
  override def poll(sensors: List[Sensor]): Unit = {
    sensors.foreach(s => checkTriggered(s))
  }

  def checkTriggered(sensor:Sensor) = {
    if (sensor.isTriggered){
      renderer.renderTrigger(sensor)
      sensor.executeNotifications
    }

    else
      renderer.renderPolled(sensor)
  }
}
