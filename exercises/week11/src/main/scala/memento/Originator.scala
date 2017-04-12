package memento

case class Originator(
  var x: Double,
  var y: Double,
  var careTaker: CareTaker
) {

  private var lastUndoSavepoint: String = _

  createSavepoint("INITIAL")

  def createSavepoint(savepointName: String): Unit = {
    println(s"Saving state...$savepointName")
    careTaker.saveMemento(Memento(this.x, this.y), savepointName)
    lastUndoSavepoint = savepointName
  }

  def undo(): Unit = {
    println(s"Undo at...$lastUndoSavepoint")
    val rollback = careTaker.getMemento(lastUndoSavepoint)
    this.x = rollback.x
    this.y = rollback.y
  }

  def undo(savepointName: String): Unit = {
    println(s"Undo at...$savepointName")
    val rollback = careTaker.getMemento(savepointName)
    this.x = rollback.x
    this.y = rollback.y
  }

  def undoAll(): Unit = {
    println("Clearing all save points...")
    undo("INITIAL")
    careTaker.clearSavepoints()
  }

  private def setOriginatorState(savepointName: String): Unit = ???

  override def toString(): String = "X: " + x + ", Y: " + y
}
