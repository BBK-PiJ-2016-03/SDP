package alarm.notifiers

import alarm.{Notifier, Sensor}

/**
  * Created by Alexander Worton on 23/01/2017.
  */
class PoliceNotifier extends Notifier{
  override def notify(sensor: Sensor): Unit = {
    println("Calling Police...")
  }
}
