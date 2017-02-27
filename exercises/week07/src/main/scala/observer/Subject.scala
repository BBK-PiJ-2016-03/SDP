package observer

/**
  * Created by aworton on 27/02/17.
  */
trait Subject {

  def registerSubscriber(subscriber: Observer)

  def deregisterSubscriber(subscriber: Observer)

  def notifyObservers()

  def getLatestCommentary(): String

}
