package observer

/**
  * Created by aworton on 27/02/17.
  */
class ConcreteSubscriber(id: Int, commentary: Commentary) extends Subscriber{

  commentary.registerSubscriber(this)

  override def update(): Unit = println(s"$id received update\n${commentary.getLatestCommentary()}")
}
