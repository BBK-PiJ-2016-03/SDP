package q02command.job

import q02command.command.FileIO

/**
  * @author Alexander Worton.
  */
class FileIOJob() extends Job {
  var file: Option[FileIO] = None

  override def run: Unit = file.foreach(_.performIO())

  def setFileIO(file: FileIO) = this.file = Some(file)
}
