package classroom

/**
  * Created by aworton on 28/02/17.
  */
object AddOptions extends App{

  /**
    * accepts three Option[Int] as formal paramter and returns thier sum
    * v1 flatmap
    * v2 for comprehensions
    * @param opt1
    * @param opt2
    * @param opt3
    * @return
    */
//  def addOptions(opt1: Option[Int], opt2: Option[Int], opt3: Option[Int]): Option[Int] = {
//    opt1 flatMap(a =>
//      opt2 flatMap (b =>
//        opt3 map (c =>
//          a + b + c
//        )
//      )
//    )
//  }

  def addOptions(opt1: Option[Int], opt2: Option[Int], opt3: Option[Int]): Option[Int] = {
    for {
      a <- opt1
      b <- opt2
      c <- opt3
    } yield a + b + c
  }

  println(addOptions(Some(1), Some(2), Some(3)))
  println(addOptions(None, Some(1), Some(10)))
  println(addOptions(None, None, None))

}
