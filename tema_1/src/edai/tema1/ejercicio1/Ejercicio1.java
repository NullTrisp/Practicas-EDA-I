package edai.tema1.ejercicio1;

public class Ejercicio1 extends Object {

	public static String removeEs(String text) {
		String res = "";
		char[] textArray = text.toCharArray();

		for (char c : textArray) {
			if (c != 'e' && c != 'E') {
				res = res + c;
			}
		}
		return res;
	}
}
