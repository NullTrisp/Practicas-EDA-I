package edai.tema3.ejercicio1;

import edai.tema3.Stack;

public class NumberInverter {
	public static int[] invert(int[] numbers) {
		Stack<Integer> aux = new Stack<Integer>();
		int[] inverted = new int[numbers.length];

		for (int n : numbers) {
			aux.push(n);
		}

		for (int i = 0; i < numbers.length; i++) {
			inverted[i] = aux.pop();
		}

		return inverted;
	}
}
