package q04prototype

class User(var userName: String,
           var level: String,
           var accessControl: AccessControl) {

  override def toString(): String = s"Name: $userName, Level: $level," +
    s"Access Control Level:${accessControl.controlLevel}, Access: ${accessControl.access}"
}
