package template

case class MySqLCSVCon() extends ConnectionTemplate {
  override def setDBDriver(): Unit = ???
  override def setCredentials(): Unit = ???
  override def setData(): Unit = ???
}
