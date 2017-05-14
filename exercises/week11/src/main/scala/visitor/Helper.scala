package visitor

/**
  * @author Alexander Worton.
  */
object Helper {
  def stripBraces(input: String): String = {
    val output = input.replaceAll("<|>", "")
    output
  }
}
