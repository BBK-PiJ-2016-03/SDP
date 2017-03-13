package q4factory

import q4factory.parsers.XMLParser

/**
  * @author Alexander Worton.
  */
trait AbstractParserFactory {
  def getParserInstance(parserType: String): XMLParser
}
