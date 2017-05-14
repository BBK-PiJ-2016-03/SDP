package visitor

case class CssClassVisitor() extends Visitor {
  override def visit(element: HtmlElement): Unit = {
    val strippedTag = Helper.stripBraces(element.getStartTag())
    val sb: StringBuilder = new StringBuilder(strippedTag)
    sb.insert(strippedTag.length, " class='visitor'")
    element.setStartTag(s"<${sb.toString()}>")
  }
  override def visit(parentElement: HtmlParentElement): Unit = {
    val strippedTag = Helper.stripBraces(parentElement.getStartTag())
    val sb: StringBuilder = new StringBuilder(strippedTag)
    sb.insert(strippedTag.length, " class='visitor'")
    parentElement.setStartTag(s"<${sb.toString()}>")
  }
}
