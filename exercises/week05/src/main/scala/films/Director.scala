package films
/**
  * Created by aworton on 18/02/17.
  */
class Director(val firstName: String, val lastName: String, val yearOfBirth: Int){
  def name = firstName+" "+lastName
}

object Director{
  def apply(firstName: String, lastName: String, yearOfBirth: Int): Director = new Director(firstName, lastName, yearOfBirth)
  def older(director1: Director, director2: Director): Director = if(director1.yearOfBirth > director2.yearOfBirth) director1 else director2
}