package alarm;

import library.Populate;
import scala.collection.immutable.List;

import java.io.IOException;
import java.util.Scanner;

public class App {
  private static final String EXIT = "exit";
  private static final String POLL = "poll";
  
  public static void main(String[] args) throws IOException {
    Renderer renderer = new RendererConsole();
    SensorPoller poller = new SensorPollerGeneral(renderer);
    List<Sensor> sensors = Populate.getSensors();

    ControlUnit controlUnit = new ControlUnit(sensors, poller);

    Scanner scanner = new Scanner(System.in);
    String input = "";
    while (!input.equals(EXIT)) {
      System.out.println("Type \"poll\" to poll all sensors once or \"exit\" to exit");
      input = scanner.nextLine();
      if (input.equals(POLL)) {
        controlUnit.pollSensors();
      }
    }
  }

//  private static List<Sensor> getSensors() {
//    java.util.List<Sensor> sensors = IntStream.range(1,5)
//            .mapToObj(i -> i)
//            .flatMap(i -> (Arrays.asList(new FireSensor("Unknown"), new SmokeSensor("Unknown")).stream()))
//            .collect(Collectors.toList());
//    List<Sensor> scalaSensors = new List<>();
//
//    for(Sensor s : sensors)
//      scalaSensors.foldLeft(s);
//
//    return scalaSensors;
//  }
}
