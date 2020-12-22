package proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DataGenerator {
	private ArrayList<String> rawRoutes = new ArrayList<String>();
	private ArrayList<String> rawAirports = new ArrayList<String>();
	private ArrayList<Route> routes = new ArrayList<Route>();
	private ArrayList<Airport> airports = new ArrayList<Airport>();

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
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
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
		Iterator<String> it = this.rawRoutes.iterator();
		while (it.hasNext()) {
			String[] airportData = it.next().split(",");

			Airport newAirport = new Airport();
			newAirport.setAirportID(airportData[0]);
			newAirport.setAirportID(airportData[1]);
			newAirport.setAirportID(airportData[2]);
			newAirport.setAirportID(airportData[3]);
			newAirport.setAirportID(airportData[4]);
			newAirport.setAirportID(airportData[5]);
			newAirport.setAirportID(airportData[6]);
			newAirport.setAirportID(airportData[7]);
			newAirport.setAirportID(airportData[8]);
			newAirport.setAirportID(airportData[9]);
			newAirport.setAirportID(airportData[10]);
			newAirport.setAirportID(airportData[11]);
			newAirport.setAirportID(airportData[12]);
			newAirport.setAirportID(airportData[13]);
			airports.add(newAirport);

		}
		this.airports = airports;
		return this;
	}

	public DataGenerator getRawRoutes() {
		ArrayList<String> data = new ArrayList<String>();
		try {
			URL address = new URL("https://raw.githubusercontent.com/jpatokal/openflights/master/data/routes.dat");
			InputStream in = address.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
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
}
