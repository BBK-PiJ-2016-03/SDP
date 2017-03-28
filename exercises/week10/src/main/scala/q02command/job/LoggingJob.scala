package q02command.job

import q02command.command.Logging

/**
  * @author Alexander Worton.
  */
class LoggingJob() extends Job {
  var logger: Option[Logging] = None

  override def run: Unit = logger.foreach(_.log)

  def setLogging(logger: Logging) = this.logger = Some(logger)
}
