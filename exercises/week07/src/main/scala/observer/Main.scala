package observer

/**
  * Created by aworton on 27/02/17.
  */
object Main extends App{
  (1 to 3).foreach( id => new ConcreteObserver(id, ConcreteSubject))

  ConcreteSubject.postNewCommentary("Off to a great start!")
  ConcreteSubject.postNewCommentary("Wowzer!")

  new ConcreteObserver(4, ConcreteSubject)

  ConcreteSubject.postNewCommentary("Sports Triumph!")
  ConcreteSubject.postNewCommentary("They've scored!")

}
