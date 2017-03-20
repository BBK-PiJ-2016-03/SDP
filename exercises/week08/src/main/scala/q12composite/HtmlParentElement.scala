package q12composite

/**
  * @author Alexander Worton.
  */
case class HtmlParentElement(s: String) extends HtmlTag(s) {

  var children: List[HtmlTag] = Nil

  override def addChildTag(htmlTag: HtmlTag): Unit = children = htmlTag :: children

  override def removeChildTag(htmlTag: HtmlTag): Unit = children = removeElement(htmlTag, children)

  def removeElement(htmlTag: HtmlTag, list: List[HtmlTag]): List[HtmlTag] = list match {
    case Nil => Nil
    case head :: tail if head == htmlTag => removeElement(htmlTag, tail)
    case head :: tail => head :: removeElement(htmlTag, tail)
  }

  override def getChildren: List[HtmlTag] = children

  override def generateHtml: Unit = {
    println(startTag)
    contents
    println(endTag)
  }

  def contents: Unit = {
    for {
      child <- children.reverse
    } yield child.generateHtml
  }
}
