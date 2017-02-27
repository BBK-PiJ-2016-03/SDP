package observer

/**
  * Created by aworton on 27/02/17.
  */
object Main extends App{
  (1 to 3).foreach( id => new ConcreteSubscriber(id, ConcreteCommentary))

  ConcreteCommentary.postNewCommentary("Off to a great start!")
  ConcreteCommentary.postNewCommentary("Wowzer!")

  new ConcreteSubscriber(4, ConcreteCommentary)

  ConcreteCommentary.postNewCommentary("Sports Triumph!")
  ConcreteCommentary.postNewCommentary("They've scored!")

}
