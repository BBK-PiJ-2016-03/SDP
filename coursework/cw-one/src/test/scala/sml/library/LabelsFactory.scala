package sml.library

import sml.Labels

/**
  * Created by aworton on 06/03/17.
  */
object LabelsFactory {
  /**
    * Create a labels object, add all of the strings passed in to the method and return it
    * @param labels sequence of strings
    * @return label object with each in the sequence added to it
    */
  def populateLabels(labels: String*): Labels = {
    val labelCollection = new Labels
    for{
      label <- labels
    } labelCollection.add(label)
    labelCollection
  }

  def getLabel(number: Int): String= {
    s"f$number"
  }
}
