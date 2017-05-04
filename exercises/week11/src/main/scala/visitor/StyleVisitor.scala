package visitor

case class StyleVisitor() extends Visitor {
  override def visit(element: HtmlElement): Unit = {
    var sb: StringBuilder = new StringBuilder(element.getStartTag())
    sb.insert(element.getStartTag().length-1, " style='width:58px;'")
    element.setStartTag(sb.toString())
  }
  override def visit(parentElement: HtmlParentElement): Unit = {
    var sb: StringBuilder = new StringBuilder(parentElement.getStartTag())
    sb.insert(parentElement.getStartTag().length-1, " style='width:46px;'")
    parentElement.setStartTag(sb.toString())
  }
}
