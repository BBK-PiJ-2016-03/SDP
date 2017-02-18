package films
/**
  * Created by aworton on 18/02/17.
  */
class Director(val firstName: String, val lastName: String, val yearOfBirth: Int){
  def name = firstName+" "+lastName
}

object Director{
  def apply(firstName: String, lastName: String, yearOfBirth: Int) = ???
  def older(director1: Director, director2: Director) = ???
}