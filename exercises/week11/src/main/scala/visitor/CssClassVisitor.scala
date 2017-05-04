package visitor

case class CssClassVisitor() extends Visitor {
  override def visit(element: HtmlElement): Unit = ???
  override def visit(parentElement: HtmlParentElement): Unit = ???
}
