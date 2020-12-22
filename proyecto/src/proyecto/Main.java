package proyecto;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		DataGenerator dataGenerator = new DataGenerator();

		ArrayList<Route> routes = dataGenerator.getRawRoutes().createRoutes().getRoutes();
		dataGenerator.getRawAirports().createAirports();
		System.out.println("txt");

	}

	private static void printArr(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}