package q04prototype

class AccessControl(val controlLevel: String,
                    var access: String)
    extends Prototype {

  override def clone(): AccessControl = new AccessControl(controlLevel, access)
}