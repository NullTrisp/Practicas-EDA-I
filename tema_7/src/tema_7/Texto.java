package tema_7;

import java.io.Serializable;

public class Texto implements Serializable {

	private static final long serialVersionUID = -8687237288345743025L;
	private int entero;
	private float decimal;
	private String texto;

	public Texto() {
	}

	public int getEntero() {
		return entero;
	}

	public void setEntero(int entero) {
		this.entero = entero;
	}

	public float getDecimal() {
		return decimal;
	}

	public void setDecimal(float decimal) {
		this.decimal = decimal;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
