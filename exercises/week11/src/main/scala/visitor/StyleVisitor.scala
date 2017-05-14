package visitor

case class StyleVisitor() extends Visitor {
  override def visit(element: HtmlElement): Unit = {
    val strippedTag = Helper.stripBraces(element.getStartTag())
    val sb: StringBuilder = new StringBuilder(strippedTag)
    sb.insert(strippedTag.length, " style='width:46px;'")
    element.setStartTag(s"<${sb.toString()}>")
  }
  override def visit(parentElement: HtmlParentElement): Unit = {
    val strippedTag = Helper.stripBraces(parentElement.getStartTag())
    val sb: StringBuilder = new StringBuilder(strippedTag)
    sb.insert(strippedTag.length, " style='width:58px;'")
    parentElement.setStartTag(s"<${sb.toString()}>")
  }
}
