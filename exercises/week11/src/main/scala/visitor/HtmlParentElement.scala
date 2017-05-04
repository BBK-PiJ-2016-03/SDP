package visitor

case class HtmlParentElement(var tagName: String) extends HtmlTag {
  var startTag: String = tagName
  var endTag: String = s"/$tagName"

  private var childrenTag: Seq[HtmlTag] = Vector()

  override def addChildTag(htmlTag: HtmlTag): Unit = childrenTag :+ htmlTag
  override def removeChildTag(htmlTag: HtmlTag): Unit = {
    childrenTag = childrenTag.filter(e => e != htmlTag)
  }
  override def getChildren(): List[HtmlTag] = childrenTag.toList
  override def generateHtml(): Unit = {
    println(s"$startTag")
    childrenTag.foreach(_.generateHtml())
    println(s"$endTag")
  }
  override def accept(visitor: Visitor): Unit = visitor.visit(this)

  def getEndTag(): String = s"<$endTag>"
  def getStartTag(): String = s"<$startTag>"
  def getTagName(): String = tagName
  def setEndTag(tag: String): Unit = endTag = tag
  def setStartTag(tag: String): Unit = startTag = tag
}
