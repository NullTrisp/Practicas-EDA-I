package edai.tema2.ejercicio1;

public class Contact implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2339766813789489987L;
	private String firstName;
	private String lastName;
	private String company;
	private String address;
	private String email;

	public Contact() {

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCompany() {
		return company;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
