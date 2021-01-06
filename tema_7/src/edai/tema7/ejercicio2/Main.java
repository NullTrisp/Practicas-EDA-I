package edai.tema7.ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Scanner inString = new Scanner(System.in), inInt = new Scanner(System.in);
		String option;
		int currentBill;
		ATM atm = new ATM();

		System.out.println("Welcome to this personal ATM");
		// values in txt are: 10 euro bill, 20 euro bill and 50 euro bill
		while (true) {
			Thread.sleep(1000);
			System.out.println("What do you desire to do?");
			System.out.println("1 ---> Retrieve cash");
			System.out.println("2 ---> Deposit cash");
			System.out.println("3 ---> Exit");

			option = inString.nextLine();
			switch (option) {
			case "1":
				System.out.println("How much cash do you want to retrieve?");
				atm.retrieve(inInt.nextInt());
				break;
			case "2":
				int[] values = new int[3];
				boolean validValues = true;
				int inputValue;
				for (int i = 0; i < 3; i++) {
					currentBill = (i == 0) ? 10 : (i == 1) ? 20 : 50;
					System.out.println("How many $" + currentBill + " bills do desire to depost?");
					try {
						inputValue = inInt.nextInt();
						if (inputValue < 0) {
							validValues = false;
							System.err.println("\nYou cannot input negative values!");
							break;
						}
						values[i] = inputValue + atm.getAtmCash()[i];
					} catch (InputMismatchException err) {
						validValues = false;
						System.err.println("\nYou cannot input non-numeric characters!");
						break;
					}
				}
				if (validValues) {
					atm.updateAtmCash(values);
				}
				break;
			case "3":
				System.out.println("\nThank you for using this ATM!");
				inString.close();
				inInt.close();
				System.exit(0);
			default:
				System.out.println("\nPlease select a valid option!\n\n\n\n\n\n\n\n");
				break;
			}
		}

	}
}
