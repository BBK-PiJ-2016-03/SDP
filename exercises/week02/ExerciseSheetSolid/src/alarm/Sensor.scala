package alarm

/**
  * Created by Alexander Worton on 17/01/2017.
  */
trait Sensor {
  def isTriggered: Boolean

  def getLocation: String

  def getSensorType: String

  /**
    * run the set of Notifiers attached to this sensor
    */
  def executeNotifications: Unit

}
