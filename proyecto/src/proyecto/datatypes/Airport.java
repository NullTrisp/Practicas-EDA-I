package proyecto.datatypes;

import java.io.Serializable;

public class Airport implements Serializable {

	private static final long serialVersionUID = -7814433642169435380L;
	private String airportID;
	private String name;
	private String city;
	private String country;
	private String IATA;
	private String ICAO;
	private double latitude;
	private double longitude;
	private double altitude;
	private String timezone;
	private String DST;
	private String Tz;
	private String Type;
	private String Source;

	public Airport() {

	}

	public String getAirportID() {
		return airportID;
	}

	public void setAirportID(String airportID) {
		this.airportID = airportID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIATA() {
		return IATA;
	}

	public void setIATA(String iATA) {
		IATA = iATA;
	}

	public String getICAO() {
		return ICAO;
	}

	public void setICAO(String iCAO) {
		ICAO = iCAO;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getDST() {
		return DST;
	}

	public void setDST(String dST) {
		DST = dST;
	}

	public String getTz() {
		return Tz;
	}

	public void setTz(String tz) {
		Tz = tz;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
