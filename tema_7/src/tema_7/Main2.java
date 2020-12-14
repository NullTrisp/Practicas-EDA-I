package tema_7;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main2 {

	public static void main(String[] args) {

		try {
			Texto texto = new Texto();
			texto.setDecimal(2.4f);
			texto.setEntero(2);
			texto.setTexto("texto");

			DataOutputStream out;
			out = new DataOutputStream(new FileOutputStream("fichero.dat"));
			out.writeInt(texto.getEntero());
			out.writeUTF(texto.getTexto());
			out.writeFloat(texto.getDecimal());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
