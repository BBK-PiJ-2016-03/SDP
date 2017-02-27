package observer

/**
  * Created by aworton on 27/02/17.
  */
object ConcreteCommentary extends Commentary{

  var lastCommentary: String = "No posts yet"
  var subscribers: List[Subscriber] = Nil

  override def registerSubscriber(subscriber: Subscriber): Unit = {
    subscribers = subscriber :: subscribers
  }

  override def deregisterSubscriber(subscriber: Subscriber): Unit = {
    subscribers = subscribers.filter(_ != subscriber)
  }

  override def notifyObservers(): Unit = {
    subscribers.foreach(_.update())
  }

  override def getLatestCommentary(): String = lastCommentary

  def postNewCommentary(commentary: String): Unit = {
    lastCommentary = commentary
    notifyObservers()
  }
}
