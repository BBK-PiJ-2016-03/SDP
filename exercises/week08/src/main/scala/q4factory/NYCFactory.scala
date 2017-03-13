package q4factory

import q4factory.parsers.XMLParser

/**
  * @author Alexander Worton.
  */
class NYCFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String): XMLParser = parserType match {
    case "ORDER" => new
    case "RESPONSE" =>
    case "FEEDBACK" =>
    case "ERROR" =>
  }
}
