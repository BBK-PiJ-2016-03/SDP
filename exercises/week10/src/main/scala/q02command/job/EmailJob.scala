package q02command.job

import q02command.command.Email

/**
  * @author Alexander Worton.
  */
class EmailJob() extends Job {
  var email: Option[Email] = None

  override def run: Unit = email.foreach(_.sendEmail())

  def setEmail(email: Email) = this.email = Some(email)
}
