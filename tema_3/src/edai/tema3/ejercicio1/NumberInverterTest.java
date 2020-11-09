package edai.tema3.ejercicio1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class NumberInverterTest {
	@Test
	void testInvert() {
		final int[] numbers = { 1, 2, 3, 4, 5 };
		final int[] expected = { 5, 4, 3, 2, 1 };
		assertArrayEquals(expected, NumberInverter.invert(numbers));
	}
}