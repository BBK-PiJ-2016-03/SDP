package q6builder

import com.sun.java.swing.plaf.windows.resources.windows

/**
  * @author Alexander Worton.
  */
object SportsCarBuilder extends CarBuilder {
  override var car: Car = new Car("SPORTS")

  override def buildBody: CarBuilder = {
    car.setBodyStyle("""External dimensions: overall length (inches): 192.3,
    overall width (inches): 75.5, overall height (inches): 54.2,
    wheelbase (inches): 112.3, front track (inches): 63.7,
    rear track (inches): 64.1 and curb to curb turning circle (feet): 37.7""")
    this
  }

  override def buildPower: CarBuilder = {
    car.setPower("""323 hp @ 6,800 rpm; 278 ft lb of torque @ 4,800 rpm""")
    this
  }

  override def buildEngine: CarBuilder = {
    car.setEngine("""3.6L V 6 DOHC and variable valve timing""")
    this
  }

  override def buildBrakes: CarBuilder = {
    car.setBrakes("""Four-wheel disc brakes: two ventilated. Electronic brake distribution.
    Stability control""")
    this
  }

  override def buildSeats: CarBuilder = {
    car.setSeats("""Driver sports front seat with one power adjustments manual height,
    front passenger seat sports front seat with one power adjustments""")
    this
  }

  override def buildWindows: CarBuilder = {
    car.setWindows("""Front windows with one-touch on two windows""")
    this
  }

  override def buildFuelType: CarBuilder = {
    car.setFuelType("""Petrol 17 MPG city, 28 MPG highway, 20 MPG combined and 380 mi. range""")
    this
  }
}
