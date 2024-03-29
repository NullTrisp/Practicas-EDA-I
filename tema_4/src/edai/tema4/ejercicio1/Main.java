package edai.tema4.ejercicio1;

public class Main {

	public static void main(String[] args) {
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
		berlinPlane.setDestination("Berl�n");
		berlinPlane.setTakeoutSeconds(51);
		final Plane barcelonaPlane = new Plane();
		barcelonaPlane.setId(1006);
		barcelonaPlane.setAirline("Ryanair");
		barcelonaPlane.setDestination("Barcelona");
		barcelonaPlane.setTakeoutSeconds(34);
		final Plane parisPlane = new Plane();
		parisPlane.setId(1007);
		parisPlane.setAirline("Iberia");
		parisPlane.setDestination("Par�s");
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

		System.out.println("(id), (airline),(takeout seconds) (destination)");
		System.out.println("");

		System.out.println("First landing strip: ");
		printPLanes(airport.getFirstLandingStripPlanes());

		System.out.println("");
		System.out.println("");

		System.out.println("Second landing strip: ");
		printPLanes(airport.getSecondLandingStripPlanes());

	}

	public static void printPLanes(Plane[] planes) {
		for (int i = 0; i < planes.length; i++) {
			System.out.print(planes[i].getId() + ", ");
			System.out.print(planes[i].getAirline() + ", ");
			System.out.print(planes[i].getTakeoutSeconds() + " Seconds, ");
			System.out.println(planes[i].getDestination());
		}
	}
}
