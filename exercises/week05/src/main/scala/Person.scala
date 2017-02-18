/**
  * Created by aworton on 18/02/17.
  */
case class Person(val first: String, val last: String)

object Person{
  def apply(name:String): Person = {
    val parts = name.split(" ")
    val first = parts(0);
    val last = if(parts.length > 1) parts(1) else ""
    new Person(first, last)
  }
}

