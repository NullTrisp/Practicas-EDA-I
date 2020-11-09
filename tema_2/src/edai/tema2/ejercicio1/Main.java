package edai.tema2.ejercicio1;

import java.util.Scanner;

import edai.tema2.List;
import edai.tema2.Node;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		boolean exit = false;
		int userInput;
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

		System.out.println("Welcome to your address book");
		System.out.println("----------------------------");
		while (!exit) {
			System.out.println("What do you desire to do?...");
			System.out.println("1 => list all contacts");
			System.out.println("2 => list all info for one contact");
			System.out.println("3 => exit the app");
			System.out.println("");

			if (in.hasNextInt()) {
				userInput = in.nextInt();
				switch (userInput) {
				case 1:
					System.out.println("");
					System.out.println("Contact list: ");
					List<String> names = book.getContactNames();
					Node<String> current = names.getFirst();
					for (int i = 0; i < names.size(); i++) {
						System.out.println((i + 1) + ". " + current.getData());
						current = current.getNext();
					}
					System.out.println("");
					break;
				case 2:
					System.out.println("Please select a contact: ");
					in.nextLine();
					String contactInput = in.nextLine();
					Contact contactSelected = book.getContact(contactInput);
					if (contactSelected != null) {
						System.out.println("Firstname: " + contactSelected.getFirstName());
						System.out.println("Lastname: " + contactSelected.getLastName());
						System.out.println("Company: " + contactSelected.getCompany());
						System.out.println("Address: " + contactSelected.getAddress());
						System.out.println("Email: " + contactSelected.getEmail());
						System.out.println("");
					} else {
						System.out.println("There´s no contact with that name");
						System.out.println("");
					}
					break;
				case 3:
					exit = true;
					break;
				default:
					System.out.println("Please input a valid choice!");
					System.out.println("");
					break;
				}
			} else {
				in.nextLine();
				System.out.println("Enter a valid Integer value!");
				System.out.println("");
			}

		}
		System.out.println("");
		System.out.println("Thank you for using this address book :D");
		System.out.println("Exiting....");
	}

}
