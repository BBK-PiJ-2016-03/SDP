package q4abstractfactory

/**
  * @author Alexander Worton.
  */
object ParserFactoryProducer {
  def getFactory(parserType: String) = parserType match {
    case "NYCFactory" => new NYCFactory
    case "LondonFactory" => new LondonFactory
  }
}
