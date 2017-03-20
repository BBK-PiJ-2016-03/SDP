package q12composite

/**
  * @author Alexander Worton.
  */
abstract class HtmlTag(tagName: String) {

  var startTag: String = ""
  var endTag: String = ""
  var body: String = ""

  def getTagName: String = tagName

  def setStartTag(tag: String): Unit = startTag = tag

  def setEndTag(tag: String): Unit = endTag = tag

  def setTagBody(tagBody: String): Unit = body = tagBody

  def addChildTag(htmlTag: HtmlTag): Unit

  def removeChildTag(htmlTag: HtmlTag): Unit

  def getChildren: List[HtmlTag]

  def generateHtml
}
