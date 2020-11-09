package edai.tema4.ejercicio1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AirportTest {
	@Test
	void testAirportPlanes() {
		final Plane madridPlane = new Plane();
		madridPlane.setId(1001);
		madridPlane.setAirline("Ryanair");
		madridPlane.setDestination("Madrid");
		madridPlane.setTakeoutSeconds(36);
		final Plane sanFranciscoPlane = new Plane();
		sanFranciscoPlane.setId(1002);
		sanFranciscoPlane.setAirline("US Airways");
		sanFranciscoPlane.setDestination("San Francisco");
		sanFranciscoPlane.setTakeoutSeconds(41);
		final Plane menorcaPlane = new Plane();
		menorcaPlane.setId(1003);
		menorcaPlane.setAirline("Iberia");
		menorcaPlane.setDestination("Menorca");
		menorcaPlane.setTakeoutSeconds(26);
		final Plane birminghamPlane = new Plane();
		birminghamPlane.setId(1004);
		birminghamPlane.setAirline("Vueling");
		birminghamPlane.setDestination("Birmingham");
		birminghamPlane.setTakeoutSeconds(31);
		final Plane berlinPlane = new Plane();
		berlinPlane.setId(1005);
		berlinPlane.setAirline("EasyJet");
		berlinPlane.setDestination("Berlín");
		berlinPlane.setTakeoutSeconds(51);
		final Plane barcelonaPlane = new Plane();
		barcelonaPlane.setId(1006);
		barcelonaPlane.setAirline("Ryanair");
		barcelonaPlane.setDestination("Barcelona");
		barcelonaPlane.setTakeoutSeconds(34);
		final Plane parisPlane = new Plane();
		parisPlane.setId(1007);
		parisPlane.setAirline("Iberia");
		parisPlane.setDestination("París");
		parisPlane.setTakeoutSeconds(57);
		final Plane newYorkPlane = new Plane();
		newYorkPlane.setId(1008);
		newYorkPlane.setAirline("US Airways");
		newYorkPlane.setDestination("New York");
		newYorkPlane.setTakeoutSeconds(47);
		final Plane philadelphiaPlane = new Plane();
		philadelphiaPlane.setId(1009);
		philadelphiaPlane.setAirline("US Airways");
		philadelphiaPlane.setDestination("Philadelphia");
		philadelphiaPlane.setTakeoutSeconds(44);
		final Plane irvinePlane = new Plane();
		irvinePlane.setId(1010);
		irvinePlane.setAirline("Air France");
		irvinePlane.setDestination("Irvine");
		irvinePlane.setTakeoutSeconds(35);
		Plane[] planes = { madridPlane, sanFranciscoPlane, menorcaPlane, birminghamPlane, berlinPlane, barcelonaPlane,
				parisPlane, newYorkPlane, philadelphiaPlane, irvinePlane, };
		Airport airport = new Airport();
		for (Plane plane : planes) {
			airport.addPlane(plane);
		}
		final Plane[] expectedFirst = { madridPlane, menorcaPlane, berlinPlane, newYorkPlane, philadelphiaPlane };
		final Plane[] expectedSecond = { sanFranciscoPlane, birminghamPlane, barcelonaPlane, parisPlane, irvinePlane };
		assertArrayEquals(expectedFirst, airport.getFirstLandingStripPlanes());
		assertArrayEquals(expectedSecond, airport.getFirstLandingStripPlanes());
	}
}