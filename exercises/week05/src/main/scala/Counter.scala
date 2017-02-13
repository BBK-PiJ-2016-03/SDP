package week05

/**
  * Created by Alexander Worton on 13/02/2017.
  */
class Counter(val count: Int = 0){
  def inc(change:Int = 1): Counter = new Counter(count + change)
  def dec(change:Int = 1): Counter = new Counter(count - change)
  def adjust(adder:Adder): Counter = new Counter(adder add count)
}