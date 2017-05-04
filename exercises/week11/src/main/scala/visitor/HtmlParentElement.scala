package visitor

case class HtmlParentElement(var tagName: String) extends HtmlTag {
  var startTag: String = ""
  var endTag: String = ""

  private var childrenTag = ???

  override def addChildTag(htmlTag: HtmlTag): Unit = ???
  override def removeChildTag(htmlTag: HtmlTag): Unit = ???
  override def getChildren() = childrenTag
  override def generateHtml(): Unit = ???
  override def accept(visitor: Visitor): Unit = ???

  def getEndTag(): String = ???
  def getStartTag(): String = ???
  def getTagName(): String = ???
  def setEndTag(tag: String): Unit = ???
  def setStartTag(tag: String): Unit = ???
}
