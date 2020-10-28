package edai.tema2.ejercicio1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int userInput = 0;
		String contactInput = "";
		boolean exit = false;
		while (!exit) {

			AddressBook book = new AddressBook();
			System.out.println("Welcome to your address book");
			System.out.println("----------------------------");
			System.out.println("What do you desire to do?...");
			System.out.println("1 => list all contacts");
			System.out.println("2 => list all info for one contact");
			System.out.println("3 => exit the app");

			if (in.hasNextInt()) {
				userInput = in.nextInt();
				switch (userInput) {
				case 1:
					List<String> names = book.getContactNames();
					System.out.println(names.getFirst().getData());
					for (int i = 0; i < book.getContactNames().size(); i++) {
						System.out.println(names.getFirst().getNext().getData());
					}

					break;
				case 2:
					System.out.println("Please select a contact: ");
					contactInput = in.nextLine();
					book.getContact(contactInput);
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
				System.out.println("Please input a valid number");
			}

		}
		System.out.println("");
		System.out.println("Thank you for using this address book :D");
		System.out.println("Exiting....");
	}

}
