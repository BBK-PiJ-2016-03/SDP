package q01chain

/**
  * @author Alexander Worton.
  */
trait Handler {
  def setHandler(handler: Handler): Unit
  def process(file: File): Unit
  def getHandlerName(): String
}
