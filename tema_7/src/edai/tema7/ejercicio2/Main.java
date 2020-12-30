package edai.tema7.ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ATM {

	public static void main(String[] args) throws InterruptedException {
		Scanner inString = new Scanner(System.in), inInt = new Scanner(System.in);
		String option;
		int cashInput, auxCash = 0, currentBill;
		int[] atmCash = getAtmCash();
		boolean allowRetrieve = false, validInput = false;

		System.out.println("Welcome to this personal ATM");
		while (true) {
			Thread.sleep(1000);
			System.out.println("What do you desire to do?");
			System.out.println("1 ---> Retrieve cash");
			System.out.println("2 ---> Deposit cash");
			System.out.println("3 ---> Exit");

			option = inString.nextLine();
			switch (option) {
			case "1":
				// TODO update txt
				System.out.println("How much cash do you want to retrieve?");
				cashInput = inInt.nextInt();

				for (int i = 0; i < atmCash.length; i++) {
					currentBill = (i == 0) ? 10 : (i == 1) ? 20 : 50;
					if (!allowRetrieve && !validInput) {
						for (int j = 0; j < atmCash[i]; j++) {
							auxCash += currentBill;
							if (auxCash == cashInput) {
								allowRetrieve = true;
								break;
							} else if (auxCash > cashInput) {

								validInput = true;
								break;
							}
						}
					} else if (allowRetrieve) {
						System.out.println("Success!");
						break;
					} else {
						System.out.println("not success!");
						break;
					}
				}
				break;
			case "2":
				// TODO make input verifications
				for (int i = 0; i < 3; i++) {
					currentBill = (i == 0) ? 10 : (i == 1) ? 20 : 50;
					System.out.println("How many $" + currentBill + " bills do desire to depost?");
					cashInput = inInt.nextInt();
					atmCash[i] += cashInput;
				}
				updateAtmCash(atmCash);
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

	private static int[] getAtmCash() {
		StringBuffer sb = null;
		try {
			BufferedReader in = new BufferedReader(new FileReader("ATM"));

			sb = new StringBuffer();
			int c;
			while ((c = in.read()) != -1) {
				sb.append((char) c);
			}

			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return castArr(sb.toString().split(","));
	}

	private static int[] castArr(String[] arr) {
		int[] castedArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			castedArr[i] = Integer.parseInt(arr[i]);
		}
		return castedArr;
	}

	private static void updateAtmCash(int[] cash) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("ATM"));
			out.write(cash[0] + "," + cash[1] + "," + cash[2]);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
