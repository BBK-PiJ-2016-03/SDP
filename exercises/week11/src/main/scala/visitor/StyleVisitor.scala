package visitor

case class StyleVisitor() extends Visitor {
  override def visit(element: HtmlElement): Unit = ???
  override def visit(parentElement: HtmlParentElement): Unit = ???
}
