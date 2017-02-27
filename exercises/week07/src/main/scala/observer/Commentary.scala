package observer

/**
  * Created by aworton on 27/02/17.
  */
trait Commentary {

  def registerSubscriber(subscriber: Subscriber)

  def deregisterSubscriber(subscriber: Subscriber)

  def notifyObservers()

}
