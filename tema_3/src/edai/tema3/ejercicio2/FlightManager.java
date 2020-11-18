package edai.tema3.ejercicio2;

import edai.tema3.Stack;

public class FlightManager {

	public static Stack<Flight> getFlightsWithDestination(Stack<Flight> flights, String destination) {
		Stack<Flight> filteredFlights = new Stack<Flight>(), filteredFlightsInverted = new Stack<Flight>(),
				auxStack = new Stack<Flight>();
		Flight aux;
		int flightsSize = flights.size(), i;

		for (i = 0; i < flightsSize; i++) {
			aux = flights.pop();
			auxStack.push(aux);
			if (aux.getDestination().equals(destination)) {
				filteredFlights.push(aux);
			}
		}

		int filteredFlightsSize = filteredFlights.size();
		for (i = 0; i < filteredFlightsSize; i++) {
			filteredFlightsInverted.push(filteredFlights.pop());
		}

		int auxStackSize = auxStack.size();
		for (i = 0; i < auxStackSize; i++) {
			flights.push(auxStack.pop());
		}

		return filteredFlightsInverted;
	}

}
