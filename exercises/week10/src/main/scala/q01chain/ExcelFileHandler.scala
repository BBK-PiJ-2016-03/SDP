package q01chain

/**
  * @author Alexander Worton.
  */
case class ExcelFileHandler(s: String) extends Handler {
  var nextHandler: Handler = EndOfChainFileHandler()

  override def setHandler(handler: Handler): Unit = nextHandler = handler

  override def process(file: File): Unit = {
    if (file.fileType == "xls") {
      println(s"Process and saving excel file... by ${this.getHandlerName()}")
    } else {
      if (nextHandler.getHandlerName() != "End of Chain Handler" ) println(s"$s forwards request to ${nextHandler.getHandlerName()}")
      nextHandler.process(file)
    }
  }

  override def getHandlerName(): String = s
}
