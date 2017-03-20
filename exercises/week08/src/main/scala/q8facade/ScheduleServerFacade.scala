package q8facade

/**
  * @author Alexander Worton.
  */
case class ScheduleServerFacade(val server: ScheduleServer) {

  def start: Unit = {
    server.startBooting
    server.readSystemConfigFile
    server.init
    server.initializeContext
    server.initializeListeners
    server.createSystemObjects
    println("Start working......")
    println("After work done.........")
  }

  def stop: Unit = {
    server.releaseProcesses
    server.destroy
    server.destroySystemObjects
    server.destroyListeners
    server.destroyContext
    server.shutdown
  }

}
