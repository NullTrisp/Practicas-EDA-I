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

	public Person(String n, String ln, Calendar b) {
		this.name = n;
		this.lastName = ln;
		this.birthday = b;
	}

	public String getFullName() {
		return this.name + " " + this.lastName;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

}
