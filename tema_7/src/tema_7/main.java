package tema_7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class main {

	public static void main(String[] args) {

		try {
			String file = "C:\\\\Users\\\\nicolas.calvache\\\\Documents\\\\Practicas-EDA-I\\\\tema_7\\\\src\\\\tema_7\\\\fichero.txt";
			readFile(file);
			String text = "ttjrtjtte";
			BufferedWriter out = null;
			
			out = new BufferedWriter(new FileWriter(file));
			out.write(text);
			out.close();
			
			readFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readFile(String file) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));

			StringBuffer sb = new StringBuffer();
			int c;
			while ((c = in.read()) != -1) {
				sb.append((char) c);
			}

			in.close();

			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
