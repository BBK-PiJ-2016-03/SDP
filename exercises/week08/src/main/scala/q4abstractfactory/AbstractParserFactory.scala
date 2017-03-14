package q4abstractfactory

import q4abstractfactory.parsers.XMLParser

/**
  * @author Alexander Worton.
  */
trait AbstractParserFactory {
  def getParserInstance(parserType: String): XMLParser
}
