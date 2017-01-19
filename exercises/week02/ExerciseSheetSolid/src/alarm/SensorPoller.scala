package alarm

/**
  * Created by Alexander Worton on 19/01/2017.
  */
trait SensorPoller {
  def poll(sensors: List[Sensor])
}
