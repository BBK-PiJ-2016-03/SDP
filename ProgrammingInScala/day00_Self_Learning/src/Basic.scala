/**
  * Created by Alexander Worton on 08/01/2017.
  */
object Basic extends App{
  val greeting: String = "Howdy y'all"
  //println(greeting)

  val numbers: List[Int] = List(12,654,3,234,2)

  println("for...")

  for(num <- numbers)
    println(num)

  println()

  println("Max: " + numbers.max)

  println()

  println("foreach...")
  numbers.foreach(println)

  println()

  println("filtered")
  numbers.filter(e => e <= 100)
      .map(_*2)
      .foreach(println);

}
