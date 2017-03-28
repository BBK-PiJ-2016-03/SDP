package q03interpreter

import javax.swing.JFrame
import javax.swing.JOptionPane
import java.lang.reflect.Constructor
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

// Uses a "pretty" GUI - not really necessary

object MeasurementConversion extends App {
    // Create pop up window that asks for a question
    val frame: JFrame = new JFrame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    val questionAsked: String = JOptionPane.showInputDialog(frame, "What is your question")

  // Add the question to the context for analysis
    val question: ConversionContext = ConversionContext(questionAsked)
    val fromConversion: String = question.fromConversion
    val toConversion: String = question.toConversion
    val quantity: Double = question.quantity

  try {
      // Get class based on the from conversion string
      val tempClass: Class[_] = Class.forName(fromConversion)

      // Get the constructor dynamically for the conversion string
      val con: Constructor[_] = tempClass.getConstructor()

      // Create a new instance of the object you want to convert from
      val convertFrom: Any = con.newInstance().asInstanceOf[Expression]

      // Define the method parameters expected by the method that
      // will convert to your chosen unit of measure
      val methodParams: Array[Class[_]] = Array()

      // Get the method dynamically that will be needed to convert
      // into your chosen unit of measure
      val conversionMethod: Method = tempClass.getMethod(toConversion, methodParams(0))

      // Define the method parameters that will be passed to the above method
      val params = Array[Object]()

      // Get the quantity after the conversion
      val toQuantity: String = conversionMethod.invoke(convertFrom, params).asInstanceOf[String]

      // Print the results
      val answerToQues: String = question.input + toQuantity + " " + toConversion
      JOptionPane.showMessageDialog(null, answerToQues)

      // Closes the frame after OK is clicked
      frame.dispose()
    }
    catch {
      case e: ClassNotFoundException => {
        // TODO Auto-generated catch block
        e.printStackTrace()
      }
      case e: NoSuchMethodException => {
        // TODO Auto-generated catch block
        e.printStackTrace()
      }
      case e: SecurityException => {
        // TODO Auto-generated catch block
        e.printStackTrace()
      }
      case e: InstantiationException => {
        // TODO Auto-generated catch block
        e.printStackTrace()
      }
      case e: IllegalAccessException => {
        // TODO Auto-generated catch block
        e.printStackTrace()
      }
      case e: IllegalArgumentException => {
        // TODO Auto-generated catch block
        e.printStackTrace()
      }
      case e: InvocationTargetException => {
        // TODO Auto-generated catch block
        e.printStackTrace()
      }
    }
}
