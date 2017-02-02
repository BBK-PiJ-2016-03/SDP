/**
  * Created by Alexander Worton on 08/01/2017.
  */
object Basic extends App{

  //playing with tuples
  val a = (4, "h", 'q')
  println(a.getClass.getTypeName)
  println(s"${a._1} ${a._2} ${a._3}")

//  //val collection = 1 :: 2 :: 3 :: Nil
//  val collection = 1 :: 2 :: Nil
//
//  println(collection)
//
//  var collection2 = collection ::: List(5, 6)
//  println(collection2)



//  val greeting: String = "Howdy y'all"
//  //println(greeting)
//
//  val numbers: List[Int] = List(12,654,3,234,2)
//
//  println("for...")
//  for(num <- numbers)
//    println(num)
//
//  println()
//
//  println("Count: " + numbers.size)
//  println("Max: " + numbers.max)
//
//  println()
//
//  println("foreach...")
//  numbers.foreach(println)
//
//  println()
//
//  println("filtered")
//  numbers.filter(e => e <= 100)
//      .map(_*2)
//      .foreach(println);

}
