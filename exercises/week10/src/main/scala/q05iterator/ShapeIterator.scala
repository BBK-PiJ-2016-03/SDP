package q05iterator

import java.util.Iterator

class ShapeIterator(private var shapes: Array[Shape]) extends Iterator[Shape] {

  private var index = -1;

  override def hasNext(): Boolean = index < shapes.length - 1

  override def next(): Shape = {
    index += 1
    shapes(index)
  }

  override def remove(): Unit = {
    if (index >= 0) {
      shapes(index) = null
      shapes = shapes.filter(_ != null)
    }
  }
}