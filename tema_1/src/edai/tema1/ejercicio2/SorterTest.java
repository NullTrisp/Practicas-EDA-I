package edai.tema1.ejercicio2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SorterTest {
	@Test
	void testBubbleSort() {
		final int[] numbers = { 5, 1, 9, 7, 6, 3 };
		final int[] expected = { 1, 3, 5, 6, 7, 9 };
		final int[] result = Sorter.bubbleSort(numbers);
		assertArrayEquals(expected, result);
	}
}
