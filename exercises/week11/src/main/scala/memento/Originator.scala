package memento

case class Originator(
  var x: Double,
  var y: Double,
  var careTaker: CareTaker
) {

  private var lastUndoSavepoint: String = _

  createSavepoint("INITIAL")

  def createSavepoint(savepointName: String): Unit = ???

  def undo(): Unit = ???

  def undo(savepointName: String): Unit = ???

  def undoAll(): Unit = ???

  private def setOriginatorState(savepointName: String): Unit = ???

  override def toString(): String = "X: " + x + ", Y: " + y
}
