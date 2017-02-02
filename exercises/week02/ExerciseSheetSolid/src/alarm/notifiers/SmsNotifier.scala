package alarm.notifiers

import alarm.{Notifier, Sensor}

/**
  * Created by Alexander Worton on 23/01/2017.
  */
class SmsNotifier(number:String) extends Notifier{
  override def notify(sensor: Sensor): Unit = {
    println("Sending SMS to " + number + "...")
  }
}
