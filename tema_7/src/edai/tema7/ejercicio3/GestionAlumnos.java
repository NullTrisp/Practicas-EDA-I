package edai.tema7.ejercicio3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestionAlumnos {
	private ArrayList<Alumno> alumnos;

	public GestionAlumnos() {
		this.alumnos = new ArrayList<Alumno>();
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void guardarAlumnos() {
		try {
			FileOutputStream fos = new FileOutputStream("alumnos.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.alumnos);
			oos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public GestionAlumnos leerAlumnos() {
		try {
			FileInputStream fis = new FileInputStream("alumnos.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.alumnos = (ArrayList<Alumno>) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return this;
	}

}
