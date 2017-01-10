/**
  * Created by Alexander Worton on 10/01/2017.
  */
object ex01 extends App{

  override def main(args: Array[String]): Unit = {
    //twoPlusTwo
    //readAndPrint
    //whileLoop
    forLoop
  }

  def twoPlusTwo = println(2+2)

  def readAndPrint = {
    print("Please enter a number: ")
    val number: Double = scala.io.StdIn.readDouble()
    println("Half your number is: " + number/2)
    printf("That's a %s number\n", if (number > 100) "big" else "small")
  }

  def whileLoop = {
    var inputNum : Integer = -1
    while(inputNum != 0){
      inputNum = whileRepl
    }
  }

  def whileRepl = {
    print("Please enter a number (0 to quit): ")
    val inputNum = scala.io.StdIn.readInt()
    printf("You entered %d, this number squared is %d\n", inputNum, square(inputNum))
    inputNum
  }

  def forLoop = {
    for (num <- 1 to 25) {
      printf(num + " squared is " + square(num) + " and cubed is " + cube(num))
      println()
    }
  }

  def square(x: Int) : Int = x*x
  def cube(x: Int) : Int = x*x*x
}
