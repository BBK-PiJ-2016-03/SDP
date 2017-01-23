package alarm

import java.time.{LocalDate, LocalDateTime, LocalTime}

/**
  * Created by Alexander Worton on 23/01/2017.
  */
class SecurityControlUnit (sensors: List[Sensor], sensorPoller: SensorPoller) extends ControlUnit (sensors, sensorPoller){
  override def pollSensors: Unit = {
    val tenPm = LocalTime.of(22,0)
    val sixAm = LocalTime.of(6,0)

    if(timeCheck(tenPm, sixAm))
      super.pollSensors
  }

  def timeCheck(from: LocalTime, to: LocalTime): Boolean ={
    val today = LocalDate.now()
    val afterFrom: Boolean = !LocalDateTime.now().isBefore(LocalDateTime.of(today, from))
    val beforeTo: Boolean  = !LocalDateTime.now().isAfter(LocalDateTime.of(today, to))
    afterFrom || beforeTo
  }

}
