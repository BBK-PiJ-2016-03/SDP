package alarm

import java.io.IOException
import java.util.Scanner

import library.Populate

object App {
  private val EXIT: String = "exit"
  private val POLL: String = "poll"

  @throws[IOException]
  def main(args: Array[String]) {
    val hazardControlUnit: ControlUnit = new ControlUnit(Populate.getHazardSensors, new SensorPollerBattery(new RendererConsole))
    val scanner: Scanner = new Scanner(System.in)
    var input: String = ""
    while ((input != EXIT)) {
      {
        System.out.println("Type \"poll\" to poll all sensors once or \"exit\" to exit")
        input = scanner.nextLine
        if (input == POLL) {
          hazardControlUnit.pollSensors
        }
      }
    }
  }
}