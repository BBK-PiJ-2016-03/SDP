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

}


class BinaryTreeSet extends Actor {
  import BinaryTreeSet._
  import BinaryTreeNode._

  def createRoot: ActorRef = context.actorOf(BinaryTreeNode.props(0, initiallyRemoved = true))

  var root = createRoot

  // optional
  var pendingQueue = Queue.empty[Operation]

  // optional
  def receive = normal

  // optional
  /** Accepts `Operation` and `GC` messages. */
  val normal: Receive = { case e:Operation => root.forward(e) }

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
    case Insert(requester, id, elem) if elem < this.elem => insert(requester, id, Left, elem)
    case Insert(requester, id, elem) if elem > this.elem => insert(requester, id, Right, elem)
    case Contains(requester, id, elem) => contains(requester, id, elem)
    case Remove(requester, id, elem) => remove(requester, id, elem)
    case _ => ???
  }

  def contains(requester: ActorRef, id: Int, elem: Int): Unit = {
    // this node is the target node
    if(elem == this.elem) {
      requester ! ContainsResult(id, true)
    } else if (elem < this.elem && subNodeAvailable(Left)) {
      //target node is to the left
      getNode(Left) ! Contains(requester, id, elem)
    }
    else if (elem > this.elem && subNodeAvailable(Right)) {
      //target node is to the right
      getNode(Right) ! Contains(requester, id, elem)
    }
    else {
      //we have reached the dark depth of the tree and did not locate the requested node.
      requester ! ContainsResult(id, false)
    }
  }

  def remove(requester: ActorRef, id: Int, elem: Int): Unit = {
    // this node is targeted for deletion
    if(elem == this.elem) {
      removed = true
      requester ! OperationFinished(id)
    } else if (elem < this.elem && subNodeAvailable(Left)) {
      //target node is to the left
      getNode(Left) ! Remove(requester, id, elem)
    }
    else if (elem > this.elem && subNodeAvailable(Right)) {
      //target node is to the right
      getNode(Right) ! Remove(requester, id, elem)
    }
    else {
      //we have reached the dark depth of the tree and did not locate a node for deletion.
      requester ! OperationFinished(id)
    }
  }

  def subNodeAvailable(position: Position): Boolean = {
    subtrees.contains(position)
  }

  def getNode(position: Position): ActorRef = {
    subtrees(position)
  }

  def insert(requester: ActorRef, id: Int, position: Position, elem: Int): Unit = {
    if (!subtrees.contains(position)) {
      writeNewSubtree(position, elem)
      requester ! OperationFinished(id)
    }
    else{
      subtrees(position) ! Insert(requester, id, elem)
    }
  }

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
