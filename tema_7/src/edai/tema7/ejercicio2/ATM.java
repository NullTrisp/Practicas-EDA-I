package edai.tema7.ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ATM {

	private int[] atmCash;

	public ATM() {
		this.atmCash = setAtmCash();
	}

	public int[] getAtmCash() {
		return this.atmCash;
	}

	public ATM updateAtmCash(int[] values) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("ATM"));
			out.write(values[0] + "," + values[1] + "," + values[2]);
			out.close();
			this.atmCash = setAtmCash();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}

	private int[] setAtmCash() {
		StringBuffer sb = null;
		try {
			BufferedReader in = new BufferedReader(new FileReader("ATM"));

			sb = new StringBuffer();
			int c;
			while ((c = in.read()) != -1) {
				sb.append((char) c);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return castArr(sb.toString().split(","));
	}

	private int[] castArr(String[] arr) {
		int[] castedArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			castedArr[i] = Integer.parseInt(arr[i]);
		}
		return castedArr;
	}

	public ATM retrieve(int desiredQuantity) {
		boolean aux = true;
		int cashToRetrieve = 0, auxDesire = desiredQuantity;
		int[] auxCash = this.atmCash.clone();
		while (aux) {
			if (cashToRetrieve == auxDesire) {
				System.out.println("Retrieved " + auxDesire + "!\n");
				updateAtmCash(auxCash);
				this.atmCash = setAtmCash();
				break;
			}
			if (desiredQuantity >= 50 && auxCash[2] > 0) {
				auxCash[2] -= 1;
				cashToRetrieve += 50;
				desiredQuantity -= 50;
			} else if (desiredQuantity >= 20 && auxCash[1] > 0) {
				auxCash[1] -= 1;
				cashToRetrieve += 20;
				desiredQuantity -= 20;
			} else if (desiredQuantity >= 10 && auxCash[0] > 0) {
				auxCash[0] -= 1;
				cashToRetrieve += 10;
				desiredQuantity -= 10;
			} else {
				aux = false;
				System.err.println("Cannot retrieve this quantity\n");
			}
		}
		return this;
	}
}
