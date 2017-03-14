package q4abstractfactory

import q4abstractfactory.parsers.{LondonErrorParser, LondonFeedbackParser, LondonOrderParser,
                          LondonResponseParser, XMLParser}

/**
  * @author Alexander Worton.
  */
class LondonFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String): XMLParser = parserType match {
    case "ORDER" => new LondonOrderParser
    case "RESPONSE" => new LondonResponseParser
    case "FEEDBACK" => new LondonFeedbackParser
    case "ERROR" => new LondonErrorParser
  }
}
