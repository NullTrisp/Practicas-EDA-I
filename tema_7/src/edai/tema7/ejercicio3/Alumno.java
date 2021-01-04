package edai.tema7.ejercicio3;

import java.io.Serializable;
import java.util.HashMap;

public class Alumno implements Serializable {

	private static final long serialVersionUID = 6209810426549462266L;
	private String nombre;
	private String apellido;
	private HashMap<String, Double> asignaturaNota;

	public Alumno() {
		this.asignaturaNota = new HashMap<String, Double>();
	}

	public HashMap<String, Double> getAsignaturaNota() {
		return asignaturaNota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
