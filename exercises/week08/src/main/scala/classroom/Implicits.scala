package classroom

import scala.math.Ordering

/**
  * Created by aworton on 28/02/17.
  */
object Implicits extends App{

  implicit val rationalAscendingOrder = Ordering.fromLessThan[Rational](
    (x, y) => (x.numerator.toDouble / x.denominator) < (y.numerator.toDouble / y.denominator)
  )

  val firstList = List(Rational(1,2), Rational(3,4), Rational(1,3)).sorted
  val secondList = List(Rational(1,3), Rational(1,2), Rational(3,4))

  assert( firstList == secondList )

}
