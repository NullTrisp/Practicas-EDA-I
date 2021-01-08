package edai.tema7.ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Program {

	public static void main(String[] args) {
		String file1 = "numeros1";
		String file2 = "numeros2";

		int[] file1Numbers = castArr(readFile(file1));
		int[] file2Numbers = castArr(readFile(file2));

		int[] arrWithoutDuplicates = deleteDuplicates(Sorter.bubbleSort(mergeArr(file1Numbers, file2Numbers)));

		int[] finalArray = invertArr(arrWithoutDuplicates);

		System.out.println(Arrays.toString(Sorter.bubbleSort(mergeArr(file1Numbers, file2Numbers))));
		System.out.println(Arrays.toString(arrWithoutDuplicates));
		System.out.println(Arrays.toString((finalArray)));

		createTxt(finalArray);

	}

	private static String[] readFile(String file) {
		StringBuffer sb = null;
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));

			sb = new StringBuffer();
			int c;
			while ((c = in.read()) != -1) {
				sb.append((char) c);
			}

			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString().split("\\r\\n");
	}

	private static int[] castArr(String[] arr) {
		int[] castedArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			castedArr[i] = Integer.parseInt(arr[i]);
		}
		return castedArr;
	}

	private static int[] mergeArr(int[] a, int[] b) {
		int a1 = a.length;
		int b1 = b.length;
		int[] c = new int[a1 + b1];

		System.arraycopy(a, 0, c, 0, a1);
		System.arraycopy(b, 0, c, a1, b1);
		return c;
	}

	private static int[] deleteDuplicates(int[] arr) {
		int n = arr.length;
		int[] temp = new int[n], aux;

		int j = 0;
		for (int i = 0; i < n - 1; i++)
			if (arr[i] != arr[i + 1])
				temp[j++] = arr[i];

		temp[j++] = arr[n - 1];

		aux = new int[j];
		for (int i = 0; i < j; i++)
			aux[i] = temp[i];

		return aux;
	}

	private static int[] invertArr(int[] arr) {
		int[] auxArr = new int[arr.length];
		int j = 0;
		for (int i = arr.length - 1; j < arr.length; i--, j++) {
			auxArr[j] = arr[i];
		}
		return auxArr;
	}

	private static void createTxt(int[] data) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("resultado"));
			for (int i = 0; i < data.length; i++) {
				out.write(Integer.toString(data[i]));
				out.newLine();
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
