package proyecto.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import proyecto.datatypes.DataGenerator;

class RouteTest {

	@Test
	void checkData() {
		final DataGenerator dataGenerator = new DataGenerator().getRawRoutes().createRoutes();
		Assert.assertEquals("2B", dataGenerator.getRoutes().get(0).getAirline());
		Assert.assertEquals("410", dataGenerator.getRoutes().get(0).getAirlineID());
		Assert.assertEquals("AER", dataGenerator.getRoutes().get(0).getSourceAirport());
		Assert.assertEquals("2965", dataGenerator.getRoutes().get(0).getSourceAirportID());
		Assert.assertEquals("KZN", dataGenerator.getRoutes().get(0).getDestinationAirport());
		Assert.assertEquals("2990", dataGenerator.getRoutes().get(0).getDestinationAirportID());
		Assert.assertEquals("", dataGenerator.getRoutes().get(0).getCodeshare());
		Assert.assertEquals(0, dataGenerator.getRoutes().get(0).getStops());
		Assert.assertEquals("CR2", dataGenerator.getRoutes().get(0).getEquipment());
	}

}
