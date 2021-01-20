package proyecto.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import proyecto.datatypes.DataGenerator;

class DataGeneratorTest {

	@Test
	void getDataBeforeObtainingData() {
		final DataGenerator dataGenerator = new DataGenerator();
		Assert.assertEquals(dataGenerator.getAirports().size(), 0);
		Assert.assertEquals(dataGenerator.getRoutes().size(), 0);
	}

	@Test
	void createDataBeforeObtainingData() {
		final DataGenerator dataGenerator = new DataGenerator().createAirports().createRoutes();
		Assert.assertEquals(dataGenerator.getAirports().size(), 0);
		Assert.assertEquals(dataGenerator.getRoutes().size(), 0);
	}

	@Test
	void generateDataAfterObtainingData() {
		final DataGenerator dataGenerator = new DataGenerator().getRawAirports().getRawRoutes().createAirports()
				.createRoutes();
		Assert.assertTrue(dataGenerator.getAirports().size() > 0);
		Assert.assertTrue(dataGenerator.getRoutes().size() > 0);
	}
}
