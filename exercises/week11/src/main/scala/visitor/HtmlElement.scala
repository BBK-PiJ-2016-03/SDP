package visitor

case class HtmlElement(var tagName: String) extends HtmlTag {
  var startTag: String = ""
  var endTag: String = ""

  private var tagBody: String = ""

  override def setTagBody(tagBody: String): Unit = ???
  override def generateHtml(): Unit = ???
  override def accept(visitor: Visitor): Unit = ???

  def getEndTag(): String = ???
  def getStartTag(): String = ???
  def getTagName(): String = ???
  def setEndTag(tag: String): Unit = ???
  def setStartTag(tag: String): Unit = ???
}
