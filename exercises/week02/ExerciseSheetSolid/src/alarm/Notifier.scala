package alarm

/**
  * Created by Alexander Worton on 23/01/2017.
  */
trait Notifier {
  def notify(sensor:Sensor)
}
