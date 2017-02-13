/**
  * Created by Alexander Worton on 10/02/2017.
  * Given two strings, a and b, that may or may not be of the same length,
  * determine the minimum number of character deletions required to make a
  * and b anagrams. Any characters can be deleted from either of the strings.
  */
object Anagrams {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var a = sc.next();
    var b = sc.next();

    val aOccur: Map[Char, Int] = a.groupBy(c => c) map{ case (key:Char, value:String) => (key, value.size)}
    val bOccur: Map[Char, Int] = b.groupBy(c => c) map{ case (key:Char, value:String) => (key, value.size)}

    val aToRemoveCount = aOccur.filter(p => bOccur.getOrElse(p._1, 0) == 0)
        .map(p => p._2)
        .reduce((acc, curr) => acc + curr)

    val bToRemoveCount = bOccur.filter(p => bOccur.getOrElse(p._1, 0) == 0)
        .map(p => p._2)
        .reduce((acc, curr) => acc + curr)

    val result = aToRemoveCount + bToRemoveCount

    println(result)
  }
}
