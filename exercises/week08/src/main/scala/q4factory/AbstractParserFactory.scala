package q4factory

import q4factory.parsers.XMLParser

/**
  * @author Alexander Worton.
  */
trait AbstractParserFactory {
  abstract def getParserInstance(parserType: String): XMLParser
}
