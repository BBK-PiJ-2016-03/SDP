package q6builder

/**
  * @author Alexander Worton.
  */
case class CarDirector (builder: CarBuilder) {
  def build = {
    builder.buildBody.buildBrakes.buildEngine.buildFuelType
      .buildPower.buildSeats.buildWindows.getCar
  }
}
