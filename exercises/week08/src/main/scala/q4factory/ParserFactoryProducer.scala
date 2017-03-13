package q4factory

/**
  * @author Alexander Worton.
  */
object ParserFactoryProducer {
  def getFactory(parserType: String) = parserType match {
    case "NYCFactory" => new NYCFactory()
  }
}
