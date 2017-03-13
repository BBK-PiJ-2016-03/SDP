package q2strategy

/**
  * Created by aworton on 07/03/17.
  */
object TestStrategyPattern extends App{
  var formatter: TextFormatter = CapTextFormatter()
  var editor: TextEditor = TextEditor(formatter)
  editor.publishText("Testing text in caps formatter")
  formatter = LowerTextFormatter()
  editor = TextEditor(formatter)
  editor.publishText("Testing text in lower formatter")
}
