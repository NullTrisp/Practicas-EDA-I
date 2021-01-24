package proyecto.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import proyecto.datatypes.DataGenerator;
import proyecto.datatypes.Route;
import proyecto.datatypes.Airport;

class DataGeneratorTest {

	@Test
	void getDataBeforeObtainingData() {
		final DataGenerator dataGenerator = new DataGenerator();
		Assert.assertEquals(0, dataGenerator.getAirports().size());
		Assert.assertEquals(0, dataGenerator.getRoutes().size());
	}

	@Test
	void createDataBeforeObtainingData() {
		Assert.assertThrows(NullPointerException.class, () -> new DataGenerator().createAirports().createRoutes());
	}

	@Test
	void allDataOk() {
		final DataGenerator dataGenerator = new DataGenerator().getRawAirports().getRawRoutes().createAirports()
				.createRoutes();
		Assert.assertTrue(dataGenerator.getAirports().get(0) instanceof Airport);
		Assert.assertTrue(dataGenerator.getRoutes().get(0) instanceof Route);
		Assert.assertTrue(dataGenerator.getAirports().size() > 0);
		Assert.assertTrue(dataGenerator.getRoutes().size() > 0);
	}
}
