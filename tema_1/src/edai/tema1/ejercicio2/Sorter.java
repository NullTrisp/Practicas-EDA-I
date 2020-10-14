package edai.tema1.ejercicio2;

public class Sorter {
	public static int[] bubbleSort(int[] numbers) {
		int arrLength = numbers.length;
		for (int i = 0; i < arrLength - 1; i++)
			for (int j = 0; j < arrLength - i - 1; j++)
				if (numbers[j] > numbers[j + 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
		return numbers;
	}
}
