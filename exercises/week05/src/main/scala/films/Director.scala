package films
/**
  * Created by aworton on 18/02/17.
  */
case class Director(firstName: String, lastName: String, yearOfBirth: Int){
  def name = firstName+" "+lastName
}

object Director{
  def older(director1: Director, director2: Director): Director = if(director1.yearOfBirth < director2.yearOfBirth) director1 else director2
}