package alarm

/**
  * Created by Alexander Worton on 19/01/2017.
  */
trait Renderer {
  def renderTrigger(sensor:Sensor)
  def renderPolled(sensor:Sensor)
}
