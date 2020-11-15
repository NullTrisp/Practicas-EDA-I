package edai.tema4.ejercicio1;

import java.io.Serializable;

public class Plane implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7874261827576139852L;
	private int id;
	private String airline;
	private String destination;
	private int takeoutSeconds;

	public void setId(int id) {
		this.id = id;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setTakeoutSeconds(int takeoutSeconds) {
		this.takeoutSeconds = takeoutSeconds;
	}

	public int getTakeoutSeconds() {
		return this.takeoutSeconds;
	}

}
