package visitor

case class CssClassVisitor() extends Visitor {
  override def visit(element: HtmlElement): Unit = {
    var sb: StringBuilder = new StringBuilder(element.getStartTag())
    sb.insert(element.getStartTag().length-1, " class='visitor'")
    element.setStartTag(sb.toString())
  }
  override def visit(parentElement: HtmlParentElement): Unit = {
    val strippedTag = stripBraces(parentElement.getStartTag())
    var sb: StringBuilder = new StringBuilder(strippedTag)
    sb.insert(strippedTag.length, " class='visitor'")
    parentElement.setStartTag(s"<${sb.toString()}>")
  }

  def stripBraces(input: String): String = {
    var output = input.replaceAll("<|>", "")
    output
  }
}
