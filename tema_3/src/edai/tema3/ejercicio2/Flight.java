package edai.tema3.ejercicio2;

import java.io.Serializable;
import java.util.Calendar;

public class Flight implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4625105672847436480L;
	private int id;
	private String airline;
	private String origin;
	private String destination;
	private Calendar departure;
	private Calendar arrival;

	public void setId(int id) {
		this.id = id;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setDeparture(Calendar departure) {
		this.departure = departure;
	}

	public void setArrival(Calendar arrival) {
		this.arrival = arrival;
	}

	public int getId() {
		return this.id;
	}

	public String getDestination() {
		return this.destination;
	}

}
