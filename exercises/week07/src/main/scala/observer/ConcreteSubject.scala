package observer

/**
  * Created by aworton on 27/02/17.
  */
object ConcreteSubject extends Subject{

  var lastCommentary: String = "No posts yet"
  var subscribers: List[Observer] = Nil

  override def registerSubscriber(subscriber: Observer): Unit = {
    subscribers = subscriber :: subscribers
  }

  override def deregisterSubscriber(subscriber: Observer): Unit = {
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
