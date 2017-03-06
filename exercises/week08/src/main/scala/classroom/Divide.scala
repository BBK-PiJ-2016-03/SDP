package classroom

/**
  * Created by aworton on 28/02/17.
  */
object  Divide  extends App{

  def divide(numerator: Int, denominator: Int): Option[Double] = denominator match {
    case 0 => None
    case d => Some(numerator / d)
  }

  def divide(numerator: Option[Int], denominator: Option[Int]): Option[Double] = {
    numerator flatMap (
      n => denominator flatMap (
        d => divide(n, d)
        )
    )
  }

  println("(1, 0) " + divide(Some(1), Some(0)))
  println("(1, 2) " + divide(Some(1), Some(2)))
  println("(0, 3) " + divide(Some(0), Some(3)))

}
