package edai.tema1.ejercicio1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Ejercicio1Test {
	@Test
	void testRemoveEs() {
		final String text = "Este es mi primer ejercicio";
		final String expected = "st s mi primr jrcicio";
		final String result = Ejercicio1.removeEs(text);
		assertEquals(expected, result);
	}
}
