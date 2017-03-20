package q8facade

/**
  * @author Alexander Worton.
  */
trait ScheduleServer {
  def startBooting
  def readSystemConfigFile
  def init
  def initializeContext
  def initializeListeners
  def createSystemObjects
  def releaseProcesses
  def destroy
  def destroySystemObjects
  def destroyListeners
  def destroyContext
  def shutdown
}
