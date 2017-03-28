package q03interpreter

case class ConversionContext(val input: String) {
  var fromConversion: String = getCapitalized(partsOfQues(1))
  var toConversion: String = getLowercase(partsOfQues(3))
  var quantity: Double = partsOfQues(0).toDouble
  var conversionResponse: String = partsOfQues(0) + " " + partsOfQues(1) + " equals "
  private[q03interpreter] var partsOfQues: Array[String] = input.split(" ")

  // Make String lowercase
  def getLowercase(wordToLowercase: String): String = wordToLowercase.toLowerCase

  // Capitalizes the first letter of a word
  def getCapitalized(wordToCapitalize: String): String = {
    // Make characters lower case
    val wordToCapitalizeLower = wordToCapitalize.toLowerCase
    // Make the first character uppercase
    val wordToCapitalizeResult = Character.toUpperCase(wordToCapitalizeLower.charAt(0)) + wordToCapitalizeLower.substring(1)
    // Put s on the end if not there
    var ch = ""
    if ((wordToCapitalizeResult.charAt(wordToCapitalizeResult.length - 1)) != 's') {
      ch = "s"
    }
    wordToCapitalizeResult + ch
  }
}
