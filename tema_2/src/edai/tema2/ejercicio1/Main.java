package edai.tema2.ejercicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		boolean exit = false;
		AddressBook book = new AddressBook();

		final Contact johnAppleseed = new Contact();
		johnAppleseed.setFirstName("John");
		johnAppleseed.setLastName("Appleseed");
		johnAppleseed.setCompany("Uneatlántico");
		johnAppleseed.setAddress("Calle Isabel Torres 21");
		johnAppleseed.setEmail("john.appleseed@uneatlantico.es");
		book.addContact(johnAppleseed);
		final Contact johnDoe = new Contact();
		johnDoe.setFirstName("John");
		johnDoe.setLastName("Doe");
		johnDoe.setCompany("Ingram Micro");
		johnDoe.setAddress("Plaza Manuel Llano");
		johnDoe.setEmail("john.doe@ingrammicro.com");
		book.addContact(johnDoe);
		final Contact janeDoe = new Contact();
		janeDoe.setFirstName("Jane");
		janeDoe.setLastName("Doe");
		janeDoe.setCompany("Oracle");
		janeDoe.setAddress("Calle Albert Einstein 1");
		janeDoe.setEmail("jane.doe@oracle.com");
		book.addContact(janeDoe);

		while (!exit) {
			System.out.println("Welcome to your address book");
			System.out.println("----------------------------");
			System.out.println("What do you desire to do?...");
			System.out.println("1 => list all contacts");
			System.out.println("2 => list all info for one contact");
			System.out.println("3 => exit the app");
			try {
				int userInput = in.nextInt();

				switch (userInput) {
				case 1:
					List<String> names = book.getContactNames();
					Node<String> current = names.getFirst();
					for (int i = 0; i < names.size(); i++) {
						System.out.println(current.getData());
						current = current.getNext();
					}
					System.out.println("");
					break;
				case 2:
					System.out.println("Please select a contact: ");
					String contactInput = in.nextLine();
					Contact contactSelected = book.getContact(contactInput);
					if (contactSelected != null) {
						System.out.println("Firstname: " + contactSelected.getFirstName());
						System.out.println("Lastname: " + contactSelected.getFirstName());
						System.out.println("Company: " + contactSelected.getFirstName());
						System.out.println("Address: " + contactSelected.getFirstName());
						System.out.println("Email: " + contactSelected.getFirstName());
						System.out.println("");
					}
					System.out.println("There´s no contact with that name");
					System.out.println("");
					break;
				case 3:
					exit = true;
					break;
				default:
					System.out.println("Please input a valid choice!");
					System.out.println("");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please input a valid number!");
			}

		}
		System.out.println("");
		System.out.println("Thank you for using this address book :D");
		System.out.println("Exiting....");
	}

}
