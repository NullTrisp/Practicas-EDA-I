package proyecto.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import proyecto.datatypes.DataGenerator;

class AirportTest {

	@Test
	void checkData() {
		final DataGenerator dataGenerator = new DataGenerator().getRawAirports().createAirports();
		Assert.assertEquals("1", dataGenerator.getAirports().get(0).getAirportID());
		Assert.assertEquals("Goroka Airport", dataGenerator.getAirports().get(0).getName());
		Assert.assertEquals("Goroka", dataGenerator.getAirports().get(0).getCity());
		Assert.assertEquals("Papua New Guinea", dataGenerator.getAirports().get(0).getCountry());
		Assert.assertEquals("GKA", dataGenerator.getAirports().get(0).getIATA());
		Assert.assertEquals("AYGA", dataGenerator.getAirports().get(0).getICAO());
		Assert.assertEquals(-6.081689834590001d, dataGenerator.getAirports().get(0).getLatitude(), 0.001);
		Assert.assertEquals(145.391998291d, dataGenerator.getAirports().get(0).getLongitude(), 0.001);
		Assert.assertEquals(1609.954d, dataGenerator.getAirports().get(0).getAltitude(), 0.001); // altitude in meters
		Assert.assertEquals("10", dataGenerator.getAirports().get(0).getTimezone());
		Assert.assertEquals("U", dataGenerator.getAirports().get(0).getDST());
		Assert.assertEquals("Pacific/Port_Moresby", dataGenerator.getAirports().get(0).getTz());
		Assert.assertEquals("airport", dataGenerator.getAirports().get(0).getType());
		Assert.assertEquals("OurAirports", dataGenerator.getAirports().get(0).getSource());
	}
}
