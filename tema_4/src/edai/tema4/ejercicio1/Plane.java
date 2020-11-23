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

	public Plane() {

	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @param airline
	 */
	public void setAirline(String airline) {
		this.airline = airline;
	}

	/**
	 * 
	 * @param destination
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return
	 */
	public String getAirline() {
		return airline;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * 
	 * @param takeoutSeconds
	 */
	public void setTakeoutSeconds(int takeoutSeconds) {
		this.takeoutSeconds = takeoutSeconds;
	}

	/**
	 * 
	 * @return
	 */
	public int getTakeoutSeconds() {
		return this.takeoutSeconds;
	}

}
