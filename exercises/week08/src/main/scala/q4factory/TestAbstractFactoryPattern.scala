package q4factory

import q4factory.parsers.XMLParser

/**
  * Created by Alexander Worton on 13/03/2017.
  */
object TestAbstractFactoryPattern {
  def main(args: Array[String]) {
    var parserFactory: AbstractParserFactory = ParserFactoryProducer.getFactory("NYCFactory")
    var parser: XMLParser = parserFactory.getParserInstance("ORDER")
    var msg: String = ""
    msg = parser.parse
    println(msg)
    println("************************************")
    parserFactory = ParserFactoryProducer.getFactory("LondonFactory")
    parser = parserFactory.getParserInstance("FEEDBACK")
    msg = parser.parse
    println(msg)
  }
}

