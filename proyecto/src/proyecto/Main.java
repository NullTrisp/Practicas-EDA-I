package proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Queue<String> routes = getRoutes();
		Queue<String> airports = getAirport();
		while (!routes.isEmpty()) {
			System.out.println(routes.remove());
		}

		while (!airports.isEmpty()) {
			System.out.println(airports.remove());
		}
	}

	private static Queue<String> getRoutes() {
		Queue<String> routes = new LinkedList<>();
		try {
			URL address = new URL("https://raw.githubusercontent.com/jpatokal/openflights/master/data/routes.dat");
			InputStream in = address.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				routes.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return routes;
	}

	private static Queue<String> getAirport() {
		Queue<String> routes = new LinkedList<>();
		try {
			URL address = new URL("https://raw.githubusercontent.com/jpatokal/openflights/master/data/airports.dat");
			InputStream in = address.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				routes.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return routes;
	}
}