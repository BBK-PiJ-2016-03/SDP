package flyweight

import java.util.HashMap
import java.util.Map

object PlatformFactory {

  private val map: Map[String, Platform] = new HashMap[String, Platform]()

  private object Lock

  // this method will probably need to be synchronized
  def getPlatformInstance(platformType: String): Platform = {
    Lock.synchronized {
      if(!map.containsKey(platformType)){
        map.put(platformType, new ScalaPlatform)
      }
    }
    map.get(platformType)
  }


}
