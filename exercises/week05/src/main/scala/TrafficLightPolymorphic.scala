package scala

/**
  * Created by Alexander Worton on 07/02/2017.
  */

polymorphic way
sealed trait TrafficLight{
  def next: TrafficLight
}
final case object Red extends TrafficLight{
  override def next: TrafficLight = Green
}
final case object Amber extends TrafficLight{
  override def next: TrafficLight = Red
}
final case object Green extends TrafficLight{
  override def next:TrafficLight = Amber
}




