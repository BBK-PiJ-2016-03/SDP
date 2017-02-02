package alarm

/**
  * Created by Alexander Worton on 23/01/2017.
  */
class MockNotifier(str:String) extends Notifier{
  var hasRun = false;

  override def notify(sensor: Sensor): Unit = {
    println(str +" has run")
    this.hasRun = true;
  }
}
