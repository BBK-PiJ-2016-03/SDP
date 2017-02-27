package observer

/**
  * Created by aworton on 27/02/17.
  */
class ConcreteObserver(id: Int, commentary: Subject) extends Observer{

  commentary.registerSubscriber(this)

  override def update(): Unit = println(s"$id received update\n${commentary.getLatestCommentary()}")
}
