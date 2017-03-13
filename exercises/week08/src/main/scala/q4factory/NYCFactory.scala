package q4factory

import q4factory.parsers.{NycErrorParser, NycFeedbackParser, NycOrderParser, NycResponseParser, XMLParser}

/**
  * @author Alexander Worton.
  */
class NYCFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String): XMLParser = parserType match {
    case "ORDER" => new NycOrderParser
    case "RESPONSE" => new NycResponseParser
    case "FEEDBACK" => new NycFeedbackParser
    case "ERROR" => new NycErrorParser
  }
}
