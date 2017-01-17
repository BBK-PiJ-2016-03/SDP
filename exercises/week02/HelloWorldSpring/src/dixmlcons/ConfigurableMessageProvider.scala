package dixmlcons

class ConfigurableMessageProvider private(message: String) extends MessageProvider {

  override def getMessage: String = {
    message
  }
}