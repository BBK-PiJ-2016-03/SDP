package q01chain

/**
  * @author Alexander Worton.
  */
case class EndOfChainFileHandler() extends Handler{

  override def setHandler(handler: Handler): Unit = {}

  override def process(file: File): Unit = println("File not supported")

  override def getHandlerName(): String = "End of Chain Handler"
}
