package q06mediator

class Machine extends Colleague {

  private var mediator: MachineMediator = _

  override def setMediator(mediator: MachineMediator): Unit = this.mediator = mediator

  def start(): Unit = {
    //fill
    mediator.open()
    println(s"Filling water...")
    mediator.closed()

    //heat
    mediator.on()

    wash()
  }

  def wash(): Unit = mediator.wash()
}