package flyweight

import java.util.HashMap
import java.util.Map

object PlatformFactory {

  private var map: Map[String, Platform] = ???

  def getPlatformInstance(platformType: String): Platform = ???
  // this method will probably need to be synchronized

}
