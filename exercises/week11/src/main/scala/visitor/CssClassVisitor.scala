package visitor

case class CssClassVisitor() extends Visitor {
  override def visit(element: HtmlElement): Unit = {
    var sb: StringBuilder = new StringBuilder(element.getStartTag())
    sb.insert(element.getStartTag().length-1, " class='visitor'")
    element.setStartTag(sb.toString())
  }
  override def visit(parentElement: HtmlParentElement): Unit = {
    var sb: StringBuilder = new StringBuilder(parentElement.getStartTag())
    sb.insert(parentElement.getStartTag().length-1, " class='visitor'")
    parentElement.setStartTag(sb.toString())
  }
}
