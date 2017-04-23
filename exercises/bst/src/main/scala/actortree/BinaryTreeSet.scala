package actortree

import akka.actor._

import scala.collection.immutable.{HashMap, Queue}

object BinaryTreeSet {

  trait Operation {
    def requester: ActorRef
    def id: Int
    def elem: Int
  }

  trait OperationReply {
    def id: Int
  }

  trait InternalResponse {
    def requestor: ActorRef
    def reply: OperationReply
  }

  /** Request with identifier `id` to insert an element `elem` into the tree.
    * The actor at reference `requester` should be notified when this operation
    * is completed.
    */
  case class Insert(requester: ActorRef, id: Int, elem: Int) extends Operation

  /** Request with identifier `id` to check whether an element `elem` is present
    * in the tree. The actor at reference `requester` should be notified when
    * this operation is completed.
    */
  case class Contains(requester: ActorRef, id: Int, elem: Int) extends Operation

  /** Request with identifier `id` to remove the element `elem` from the tree.
    * The actor at reference `requester` should be notified when this operation
    * is completed.
    */
  case class Remove(requester: ActorRef, id: Int, elem: Int) extends Operation

  /** Request to perform garbage collection*/
  case object GC

  /** Holds the answer to the Contains request with identifier `id`.
    * `result` is true if and only if the element is present in the tree.
    */
  case class ContainsResult(id: Int, result: Boolean) extends OperationReply
  
  /** Message to signal successful completion of an insert or remove operation. */
  case class OperationFinished(id: Int) extends OperationReply

  /** Message to base holding OperationReply */
  case class WrappedResponse(requestor: ActorRef, reply: OperationReply) extends InternalResponse

}


class BinaryTreeSet extends Actor {
  import BinaryTreeSet._
  import BinaryTreeNode._
  import scala.collection.mutable.Queue

  val messageOrder = Queue[Operation]()

  def createRoot: ActorRef = context.actorOf(BinaryTreeNode.props(0, initiallyRemoved = true))

  var root = createRoot

  // optional
  var pendingQueue = Queue.empty[Operation]

  // optional
  def receive = normal

  var pendingResponse = false

  // optional
  /** Accepts `Operation` and `GC` messages. */
  val normal: Receive = {
    case msg:Operation => enqueue(msg)
    case msg:InternalResponse => forwardResponse(msg)
  }

  /**
    * extract the response and forward it in order of receipt
    * execute the next pending instruction
    * @param response
    */
  def forwardResponse(response: InternalResponse): Unit = {
    println(s"Received response from children")
    println(s"Sending ${response.requestor} : ${response.reply}")
    response.requestor ! response.reply

    if(pendingQueue.size > 0) {
      val msg = pendingQueue.dequeue()
      root ! msg
    } else {
      pendingResponse = false
    }
  }

  /**
    * if no current operation is underway, send the operation message to root. Otherwise add the
    * message to the queue for in-order execution.
    * @param operation the received operation to enqueue
    */
  def enqueue(operation: Operation): Unit = {
    println(s"Received operation")
    if(!pendingResponse) {
      root ! operation
      pendingResponse = true
    } else{
      pendingQueue.enqueue(operation)
    }

  }

  // optional
  /** Handles messages while garbage collection is performed.
    * `newRoot` is the root of the new binary tree where we want to copy
    * all non-removed elements into.
    */
  def garbageCollecting(newRoot: ActorRef): Receive = ???
}

object BinaryTreeNode {
  trait Position

  case object Left extends Position
  case object Right extends Position

  case class CopyTo(treeNode: ActorRef)
  case object CopyFinished

  def props(elem: Int, initiallyRemoved: Boolean) = Props(
    classOf[BinaryTreeNode],
    elem,
    initiallyRemoved
  )
}

class BinaryTreeNode(val elem: Int, initiallyRemoved: Boolean) extends Actor {
  import BinaryTreeNode._
  import BinaryTreeSet._

  var subtrees = Map[Position, ActorRef]()
  var removed = initiallyRemoved

  // optional
  def receive = normal

  // optional
  /** Handles `Operation` messages and `CopyTo` requests. */
  val normal: Receive = {
    case Insert(requester, id, elem) if elem < this.elem
          => insert(sender, requester, id, Left, elem)
    case Insert(requester, id, elem) if elem > this.elem
          => insert(sender, requester, id, Right, elem)
    case Insert(requester, id, elem) if elem == this.elem => removed = false
    case Contains(requester, id, elem) => contains(sender, requester, id, elem)
    case Remove(requester, id, elem) => remove(sender, requester, id, elem)
    case _ => println(s"Unknown message")
  }

  /**
    * contains handles the check on the current node and appropriate forwarding of message in the
    * event that the message needs to be passed down into nodes in either the left or right subtree
    * @param base the control actor
    * @param requester the originator of the message
    * @param id the id of the received instruction
    * @param elem the search target value
    */
  def contains(base: ActorRef, requester: ActorRef, id: Int, elem: Int): Unit = {
    // this node is the target node
    if(elem == this.elem) {
      if (removed){
        base ! WrappedResponse(requester, ContainsResult(id, false))
      } else {
        base ! WrappedResponse(requester, ContainsResult(id, true))
      }

    } else if (elem < this.elem && subNodeAvailable(Left)) {
      //target node is to the left
      getNode(Left).tell(Contains(requester, id, elem), base)
    }
    else if (elem > this.elem && subNodeAvailable(Right)) {
      //target node is to the right
      getNode(Right).tell(Contains(requester, id, elem), base)
    }
    else {
      //we have reached the dark depth of the tree and did not locate the requested node.
      base ! WrappedResponse(requester, ContainsResult(id, false))
    }
  }

  /**
    * remove handles the flagging of the current node as removed if it matched the target, or the
    * appropriate message forwarding to nodes in the left or right subtree.
    * @param base the control actor
    * @param requester the originator of the message
    * @param id the id of the received instruction
    * @param elem the search target value
    */
  def remove(base: ActorRef, requester: ActorRef, id: Int, elem: Int): Unit = {
    // this node is targeted for deletion
    if(elem == this.elem) {
      removed = true
      base ! WrappedResponse(requester, OperationFinished(id))
    } else if (elem < this.elem && subNodeAvailable(Left)) {
      //target node is to the left
      getNode(Left).tell(Remove(requester, id, elem), base)
    }
    else if (elem > this.elem && subNodeAvailable(Right)) {
      //target node is to the right
      getNode(Right).tell(Remove(requester, id, elem), base)
    }
    else {
      //we have reached the dark depth of the tree and did not locate a node for deletion.
      base ! WrappedResponse(requester, OperationFinished(id))
    }
  }

  /**
    * subNodeAvailable returns a boolean to indicate whether the node in the provided position
    * exists.
    * @param position Left or Right
    * @return true if it exists, false otherwise
    */
  def subNodeAvailable(position: Position): Boolean = {
    subtrees.contains(position)
  }

  /**
    * getNode
    * @param position Left or Right
    * @return the node in the supplied position
    */
  def getNode(position: Position): ActorRef = {
    subtrees(position)
  }

  /**
    * insert handles the insertion of the node in the correct position or forwards the message
    * down the tree to an available slot.
    * @param base the control actor
    * @param requester the originator of the message
    * @param id the id of the received instruction
    * @param position Left or Right
    * @param elem the search target value
    */
  def insert(base: ActorRef, requester: ActorRef, id: Int, position: Position, elem: Int): Unit
  = {
    if (!subtrees.contains(position)) {
      writeNewSubtree(position, elem)
      base ! WrappedResponse(requester, OperationFinished(id))
    }
    else{
      subtrees(position).tell(Insert(requester, id, elem), base)
    }
  }

  /**
    * writeNewSubtree handles the actual write to replace the subtrees value by retaining an
    * existing node or not for the node not being currently written.
    * @param position Left or Right
    * @param elem the new node value
    */
  def writeNewSubtree(position: Position, elem: Int): Unit ={
    val other = otherPosition(position)
    if (!subtrees.contains(other)){
      subtrees = HashMap(
        position -> context.actorOf(BinaryTreeNode.props(elem, initiallyRemoved = false))
      )
    } else {
      subtrees = HashMap(
        position -> context.actorOf(BinaryTreeNode.props(elem, initiallyRemoved = false)),
        other -> subtrees(other)
      )
    }
  }

  /**
    * otherPosition gets the position not supplied. If Left is provides it returns Right and
    * vice-versa
    * @param position the current Left or Right
    * @return Left or Right opposite to the position
    */
  def otherPosition(position: Position): Position = position match {
    case Left => Right
    case Right => Left
  }

  // optional
  /** `expected` is the set of ActorRefs whose replies we are waiting for,
    * `insertConfirmed` tracks whether the copy of this node to the new tree has been confirmed.
    */
  def copying(expected: Set[ActorRef], insertConfirmed: Boolean): Receive = ???

}
