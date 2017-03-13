package q2strategy

/**
  * Created by aworton on 07/03/17.
  */
case class TextEditor(formatter: TextFormatter) {
  def publishText(s: String): Unit = println(formatter.format(s))

}
