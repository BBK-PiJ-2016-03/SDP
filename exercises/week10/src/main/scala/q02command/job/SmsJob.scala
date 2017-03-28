package q02command.job

import q02command.command.Sms

/**
  * @author Alexander Worton.
  */
class SmsJob() extends Job {
  var sms: Option[Sms] = None

  override def run: Unit = sms.foreach(_.sendSms)

  def setSms(sms: Sms) = this.sms = Some(sms)
}
