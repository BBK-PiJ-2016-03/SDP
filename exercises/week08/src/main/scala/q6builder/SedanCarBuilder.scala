package q6builder

/**
  * @author Alexander Worton.
  */
object SedanCarBuilder extends CarBuilder {
  override var car: Car = new Car("SEDAN")

  override def buildBody: CarBuilder = {
    car.setBodyStyle("""External dimensions: overall length (inches): 202.9,
    overall width (inches): 76.2, overall height (inches): 60.7,
    wheelbase (inches): 112.9, front track (inches): 65.3,
    rear track (inches): 65.5 and curb to curb turning circle (feet): 39.5""")
    this
  }

  override def buildPower: CarBuilder = {
    car.setPower("""285 hp @ 6,500 rpm; 253 ft lb of torque @ 4,000 rpm""")
    this
  }

  override def buildEngine: CarBuilder = {
    car.setEngine(""" 3.5L Duramax V 6 DOHC""")
    this
  }

  override def buildBrakes: CarBuilder = {
    car.setBrakes(""" Four-wheel disc brakes: two ventilated. Electronic brake distribution""")
    this
  }

  override def buildSeats: CarBuilder = {
    car.setSeats("""Front seat centre armrest.Rear seat centre armrest.Split-folding rear seats""")
    this
  }

  override def buildWindows: CarBuilder = {
    car.setWindows("""Laminated side windows.Fixed rear window with defroster""")
    this
  }

  override def buildFuelType: CarBuilder = {
    car.setFuelType("""Diesel 19 MPG city, 29 MPG highway, 23 MPG combined and 437 mi. range""")
    this
  }
}
