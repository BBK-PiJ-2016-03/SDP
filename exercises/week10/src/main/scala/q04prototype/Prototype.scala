package q04prototype

trait Prototype extends Cloneable {
  override def clone(): AccessControl = this.clone()
}