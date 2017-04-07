package q06mediator

trait Colleague {
  def setMediator(mediator: MachineMediator): Unit
}