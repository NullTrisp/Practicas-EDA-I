package proyecto.datatypes;

public class Route {
	private String airline;
	private String airlineID;
	private String sourceAirport;
	private String sourceAirportID;
	private String destinationAirport;
	private String destinationAirportID;
	private String codeshare;
	private int stops;
	private String equipment;

	public Route() {

	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getAirlineID() {
		return airlineID;
	}

	public void setAirlineID(String airlineID) {
		this.airlineID = airlineID;
	}

	public String getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(String sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public String getSourceAirportID() {
		return sourceAirportID;
	}

	public void setSourceAirportID(String sourceAirportID) {
		this.sourceAirportID = sourceAirportID;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public String getDestinationAirportID() {
		return destinationAirportID;
	}

	public void setDestinationAirportID(String destinationAirportID) {
		this.destinationAirportID = destinationAirportID;
	}

	public String getCodeshare() {
		return codeshare;
	}

	public void setCodeshare(String codeshare) {
		this.codeshare = codeshare;
	}

	public int getStops() {
		return stops;
	}

	public void setStops(int stops) {
		this.stops = stops;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

}
