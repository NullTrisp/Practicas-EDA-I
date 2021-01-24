package proyecto.datatypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class DataGenerator {
	private ArrayList<String> rawRoutes;
	private ArrayList<String> rawAirports;
	private ArrayList<Route> routes;
	private ArrayList<Airport> airports;

	public DataGenerator() {
		this.rawAirports = new ArrayList<String>();
		this.rawAirports = new ArrayList<String>();
		this.routes = new ArrayList<Route>();
		this.airports = new ArrayList<Airport>();
	}

	public ArrayList<Route> getRoutes() {
		return routes;
	}

	public ArrayList<Airport> getAirports() {
		return airports;
	}

	public DataGenerator getRawAirports() {
		ArrayList<String> data = new ArrayList<String>();
		try {
			URL address = new URL("https://raw.githubusercontent.com/jpatokal/openflights/master/data/airports.dat");
			InputStream in = address.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			String line;
			while ((line = reader.readLine()) != null) {
				data.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		this.rawAirports = data;
		return this;
	}

	public DataGenerator createAirports() {
		ArrayList<Airport> airports = new ArrayList<Airport>();
		Iterator<String> it = this.rawAirports.iterator();
		while (it.hasNext()) {
			String[] airportData = it.next().split(",");

			if (airportData.length > 14) { // Airport 641 gives headaches
				Airport newAirport = new Airport();
				newAirport.setAirportID(airportData[0]);
				newAirport.setName(airportData[1].replace("\"", "") + ", " + airportData[2].replace("\"", ""));
				newAirport.setCity(airportData[3].replace("\"", ""));
				newAirport.setCountry(airportData[4].replace("\"", ""));
				newAirport.setIATA(airportData[5].replace("\"", ""));
				newAirport.setICAO(airportData[6].replace("\"", ""));
				newAirport.setLatitude(Double.parseDouble(airportData[7]));
				newAirport.setLongitude(Double.parseDouble(airportData[8]));
				newAirport.setAltitude(Double.parseDouble(airportData[9]) * 0.3048); // storing as meters
				newAirport.setTimezone(airportData[10].replace("\"", ""));
				newAirport.setDST(airportData[11].replace("\"", ""));
				newAirport.setTz(airportData[12].replace("\"", ""));
				newAirport.setType(airportData[13].replace("\"", ""));
				newAirport.setSource(airportData[14].replace("\"", ""));
				airports.add(newAirport);
			} else {
				Airport newAirport = new Airport();
				newAirport.setAirportID(airportData[0]);
				newAirport.setName(airportData[1].replace("\"", ""));
				newAirport.setCity(airportData[2].replace("\"", ""));
				newAirport.setCountry(airportData[3].replace("\"", ""));
				newAirport.setIATA(airportData[4].replace("\"", ""));
				newAirport.setICAO(airportData[5].replace("\"", ""));
				newAirport.setLatitude(Double.parseDouble(airportData[6]));
				newAirport.setLongitude(Double.parseDouble(airportData[7]));
				newAirport.setAltitude(Double.parseDouble(airportData[8]) * 0.3048); // storing as meters
				newAirport.setTimezone(airportData[9].replace("\"", ""));
				newAirport.setDST(airportData[10].replace("\"", ""));
				newAirport.setTz(airportData[11].replace("\"", ""));
				newAirport.setType(airportData[12].replace("\"", ""));
				newAirport.setSource(airportData[13].replace("\"", ""));
				airports.add(newAirport);
			}

		}
		this.airports = airports;
		return this;
	}

	public DataGenerator getRawRoutes() {
		ArrayList<String> data = new ArrayList<String>();
		try {
			URL address = new URL("https://raw.githubusercontent.com/jpatokal/openflights/master/data/routes.dat");
			InputStream in = address.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			String line;
			while ((line = reader.readLine()) != null) {
				data.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		this.rawRoutes = data;
		return this;
	}

	public DataGenerator createRoutes() {
		ArrayList<Route> routes = new ArrayList<Route>();
		Iterator<String> it = this.rawRoutes.iterator();
		while (it.hasNext()) {
			String[] routeData = it.next().split(",");
			if (routeData.length != 8) {
				Route newRoute = new Route();
				newRoute.setAirline(routeData[0]);
				newRoute.setAirlineID(routeData[1]);
				newRoute.setSourceAirport(routeData[2]);
				newRoute.setSourceAirportID(routeData[3]);
				newRoute.setDestinationAirport(routeData[4]);
				newRoute.setDestinationAirportID(routeData[5]);
				newRoute.setCodeshare(routeData[6]);
				newRoute.setStops(Integer.parseInt(routeData[7]));
				newRoute.setEquipment(routeData[8]);
				routes.add(newRoute);
			} else {
				Route newRoute = new Route();
				newRoute.setAirline(routeData[0]);
				newRoute.setAirlineID(routeData[1]);
				newRoute.setSourceAirport(routeData[2]);
				newRoute.setSourceAirportID(routeData[3]);
				newRoute.setDestinationAirport(routeData[4]);
				newRoute.setDestinationAirportID(routeData[5]);
				newRoute.setCodeshare(routeData[6]);
				newRoute.setStops(Integer.parseInt(routeData[7]));
				newRoute.setEquipment("");
				routes.add(newRoute);
			}

		}
		this.routes = routes;
		return this;
	}

	public Airport getByNameAndCountry(String name, String country) {
		Airport airportFound = null;
		for (int i = 0; i < this.airports.size(); i++) {
			if (this.airports.get(i).getName().equals(name) && this.airports.get(i).getCountry().equals(country)) {
				airportFound = this.airports.get(i);
			}
		}
		return airportFound;
	}
}
