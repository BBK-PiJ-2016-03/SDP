package q12composite

/**
  * @author Alexander Worton.
  */
case class HtmlElement(s: String) extends HtmlTag(s) {
  override def addChildTag(htmlTag: HtmlTag): Unit = {}

  override def removeChildTag(htmlTag: HtmlTag): Unit = {}

  override def getChildren: List[HtmlTag] = Nil

  override def generateHtml: Unit = println(s"$startTag$body$endTag")
}
