package strategy

/**
  * Created by aworton on 07/03/17.
  */
case class CapTextFormatter() extends TextFormatter{
  override def format(text: String): String = text.toUpperCase
}
