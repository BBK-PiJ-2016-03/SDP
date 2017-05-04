package template

case class OracleTxtCon() extends ConnectionTemplate {
  override def setDBDriver(): Unit = ???
  override def setCredentials(): Unit = ???
  override def setData(): Unit = ???
}
