package alarm

import alarm.sensors.MotionSensor
import org.junit.Test
import org.junit.Assert.assertTrue
/**
  * Created by Alexander Worton on 23/01/2017.
  */
class MotionSensorTest {

  @Test def runNotifications() = {
    val mockEmail: MockNotifier = new MockNotifier("Sending email")
    val mockSoundAlarm: MockNotifier = new MockNotifier("Sounding alarm")
    val mockSendSms: MockNotifier = new MockNotifier("Sending SMS")
    val mockCallPolice: MockNotifier = new MockNotifier("Calling Police")

    val sensor:MotionSensor = new MotionSensor("Test area")
    sensor.notifiers = mockEmail :: mockSoundAlarm :: mockSendSms :: mockCallPolice :: Nil

    sensor.executeNotifications

    sensor.notifiers
      .map(n => n.asInstanceOf[MockNotifier])
      .foreach((n: MockNotifier) => assertTrue(n.hasRun))

  }

}
