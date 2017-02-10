package scala

/**
  * Created by Alexander Worton on 07/02/2017.
  */

//pattern matching way
protected sealed trait TrafficLight{
  def next: TrafficLight = this match {
    case Red => Green
    case Green => Amber
    case Amber => Red
  }
}
final case object Red extends TrafficLight
final case object Amber extends TrafficLight
final case object Green extends TrafficLight
