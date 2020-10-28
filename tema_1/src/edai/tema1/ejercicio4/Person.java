package edai.tema1.ejercicio4;

import java.util.Calendar;

public class Person implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6507202445493089340L;

	private String name;
	private String lastName;
	private Calendar birthday;
	private String country;

	public Person(String n, String ln, Calendar b, String c) {
		this.name = n;
		this.lastName = ln;
		this.birthday = b;
		this.country = c;
	}

	public Person(String n, String ln, Calendar b) {
		this.name = n;
		this.lastName = ln;
		this.birthday = b;
	}

	/**
	 * Method to get the name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to get the lastname
	 * 
	 * @return lastname
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Method to get the fullname
	 * 
	 * @return fullname
	 */
	public String getFullName() {
		return this.name + " " + this.lastName;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Method to get the age at a given date
	 * 
	 * @param date date to compare the age
	 * @return age at the date
	 */
	public int getAgeAtDate(Calendar date) {
		int yearPerson = this.birthday.get(Calendar.YEAR);
		int yearRecieved = date.get(Calendar.YEAR);
		int yearDiff = yearRecieved - yearPerson;

		if (yearDiff > 0) {
			int monthPerson = this.birthday.get(Calendar.MONTH) + 1;
			int monthRecieved = date.get(Calendar.MONTH) + 1;
			int monthDiff = monthRecieved - monthPerson;

			if (monthDiff < 0) {
				yearDiff--;
			} else if (monthDiff == 0) {
				int dayPerson = this.birthday.get(Calendar.DAY_OF_MONTH);
				int dayRecieved = date.get(Calendar.DAY_OF_MONTH);
				int dayDiff = dayRecieved - dayPerson;

				if (dayDiff < 0) {
					yearDiff--;
				}
			}
			return yearDiff;
		}
		return 0;
	}
}
