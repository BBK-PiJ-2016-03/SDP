package sml

/**
  * Created by aworton on 06/03/17.
  */
object Console {

  private var _lastPrint: Any = ""

  def lastPrint: Any = _lastPrint

  def write(printObject: Any): Unit ={
    _lastPrint = printObject
    println(printObject)
  }

}
