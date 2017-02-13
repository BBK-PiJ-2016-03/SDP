package week05

/**
  * Created by Alexander Worton on 13/02/2017.
  */
case class CounterCase(count: Int = 0){
  def inc(change: Int = 1): CounterCase = this.copy(this.count + change)
  def dec(change: Int = 1): CounterCase = this.copy(this.count - change)
}