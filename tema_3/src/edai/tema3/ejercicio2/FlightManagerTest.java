package edai.tema3.ejercicio2;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edai.tema3.Stack;

class FlightManagerTest {
	private Stack<Flight> flights;

	@BeforeEach
	void setUp() {
		final Flight santanderMadrid = new Flight();
		santanderMadrid.setId(1001);
		santanderMadrid.setAirline("Iberia");
		santanderMadrid.setOrigin("Santander");
		santanderMadrid.setDestination("Madrid");
		santanderMadrid.setDeparture(new Calendar.Builder().setFields(Calendar.YEAR, 2020, Calendar.MONTH, 8,
				Calendar.DATE, 1, Calendar.HOUR, 15, Calendar.MINUTE, 25).build());
		santanderMadrid.setArrival(new Calendar.Builder().setFields(Calendar.YEAR, 2020, Calendar.MONTH, 8,
				Calendar.DATE, 1, Calendar.HOUR, 16, Calendar.MINUTE, 15).build());
		final Flight santanderMenorca = new Flight();
		santanderMenorca.setId(2001);
		santanderMenorca.setAirline("Volotea");
		santanderMenorca.setOrigin("Santander");
		santanderMenorca.setDestination("Menorca");
		santanderMenorca.setDeparture(new Calendar.Builder().setFields(Calendar.YEAR, 2020, Calendar.MONTH, 8,
				Calendar.DATE, 3, Calendar.HOUR, 9, Calendar.MINUTE, 00).build());
		santanderMenorca.setArrival(new Calendar.Builder().setFields(Calendar.YEAR, 2020, Calendar.MONTH, 8,
				Calendar.DATE, 3, Calendar.HOUR, 11, Calendar.MINUTE, 00).build());
		final Flight santanderMadrid2 = new Flight();
		santanderMadrid2.setId(3001);
		santanderMadrid2.setAirline("Ryanair");
		santanderMadrid2.setOrigin("Santander");
		santanderMadrid2.setDestination("Madrid");
		santanderMadrid2.setDeparture(new Calendar.Builder().setFields(Calendar.YEAR, 2020, Calendar.MONTH, 9,
				Calendar.DATE, 21, Calendar.HOUR, 21, Calendar.MINUTE, 45).build());
		santanderMadrid2.setArrival(new Calendar.Builder().setFields(Calendar.YEAR, 2020, Calendar.MONTH, 9,
				Calendar.DATE, 21, Calendar.HOUR, 22, Calendar.MINUTE, 30).build());
		this.flights = new Stack<Flight>();
		this.flights.push(santanderMadrid);
		this.flights.push(santanderMenorca);
		this.flights.push(santanderMadrid2);
	}

	@Test
	void testExpectedIds() {
		final Stack<Flight> result = FlightManager.getFlightsWithDestination(flights, "Madrid");
		final Object[] expectedIds = Stream.of(result.listData())
				.map(flight -> Integer.valueOf(((Flight) flight).getId())).toArray();
		assertArrayEquals(expectedIds, new Integer[] { 3001, 1001 });
	}

	@Test
	void testOriginalStack() {
		FlightManager.getFlightsWithDestination(flights, "Madrid");
		final Object[] expectedIds = Stream.of(flights.listData())
				.map(flight -> Integer.valueOf(((Flight) flight).getId())).toArray();
		assertArrayEquals(expectedIds, new Integer[] { 3001, 2001, 1001 });
	}
}