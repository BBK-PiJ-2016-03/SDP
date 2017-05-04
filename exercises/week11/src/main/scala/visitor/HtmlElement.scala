package visitor

case class HtmlElement(var tagName: String) extends HtmlTag {
  var startTag: String = tagName
  var endTag: String = s"/$tagName"

  private var tagBody: String = ""

  override def setTagBody(tagBody: String): Unit = this.tagBody = tagBody
  override def generateHtml(): Unit = {
    print(s"$startTag")
    print(s"$tagBody")
    println(s"$endTag")
  }
  override def accept(visitor: Visitor): Unit = visitor.visit(this)

  def getEndTag(): String = s"<$endTag>"
  def getStartTag(): String = s"<$startTag>"
  def getTagName(): String = tagName
  def setEndTag(tag: String): Unit = endTag = tag
  def setStartTag(tag: String): Unit = startTag = tag
}
