package test;

import staff.*;
import buyers.*;
import shared.*;

/*
 * TESTS:
 * 
 * 
 * */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class mainFile {

	private static Scanner scan = new Scanner(System.in);
	private static String username, password, title = null, response;
	private static Buyer buyer;
	private static Staff staff;
	private static Document d = null;
	private static String choice;
	private static int isbn;
	private static ArrayList<Promotion> promos;
	private static Inventory inventory;

	public static void operator() throws IOException {

		while (true) {
			System.out.println("What would you like to do? Please choose one of the following:\n1.Add a document\n"
					+ "2.Remove a document\n" + "3.Update a document\n" + "4.Quit\n");
			choice = scan.nextLine();

			if (choice.length() > 1) {
				System.out.println("Invalid input. Please try again.");
			} else if (choice.compareTo("1") < 0 || choice.compareTo("4") > 0) {
				System.out.println("Invalid input. Please try again.");
			}

			else if (Integer.parseInt(choice) == 1) {
				System.out.println("Please enter name of document you would like to add:");
				title = scan.nextLine();
				// d = ((Operator)staff).addDoc(title); Fix this based on how to pass document

			} // choice 1 statement

			else if (Integer.parseInt(choice) == 2) {
				if (d == null) {
					System.out.println("Please choose a document first!");
					continue;
				} else {
					System.out.println("Would you like to remove " + isbn + "? (yes/no)");
					response = scan.nextLine();
					if (response.equals("yes")) {
						((Operator) staff).removeDoc(isbn);
						d = null;
						continue;
					}
				}
			} // choice 2 if statement

			else if (Integer.parseInt(choice) == 3) {
				/*
				 * Update doc here
				 */

			} // choice 3 statement

			else if (Integer.parseInt(choice) == 4) {
				System.out.println("Have a good day!");
				login();
			} // Choice 4 statement
		} // End of while

	}

	public static void registeredBuyer() throws IOException {

		while (true) {
			System.out.println("What would you like to do? Please choose one of the following:\n1.Search a book\n"
								+ "2.Unsubscribe\n" + "3.Purchase\n"+ "4.Quit");
			choice = scan.nextLine();

			if (choice.length() > 1) {
				System.out.println("Invalid input. Please try again.");
			} else if (choice.compareTo("1") < 0 || choice.compareTo("4") > 0) {
				System.out.println("Invalid input. Please try again.");
			}

			else if (Integer.parseInt(choice) == 1) {
				System.out.println("Please enter name of book:");
				title = scan.nextLine();
				d = buyer.searchCatalog(title);
				
				
				if (d == null) {
					System.out.println("Could not find that title.");
					
				} else {
					System.out.print("Found " + d.getTitle() + "! Price: ");
					System.out.printf("%.2f%n\n",d.getPrice());
					
					System.out.println("Would you like to add " + title + " to your shopping cart? (yes/no)");
					response = scan.nextLine();
					if (response.equals("yes")) {
						buyer.getOrder().addDoc(d);
						d = null;
					}
					else if(response.equals("no")) {
						System.out.println("Adding document canceled.");
						d = null;
					}
					else {
						System.out.println("Invalid input!");
					}
				}
			} // choice 1 statement

			else if (Integer.parseInt(choice) == 2) {
				scan = new Scanner(System.in);
				((RegisteredBuyer) buyer).unsubscribe();
				System.out.println("You have unsubscribed!");
				login();
			} // choice 3 statement
			
			else if (Integer.parseInt(choice) == 3) {
				if(!buyer.showList()) {
					
					System.out.println("You have no orders!");
					continue;
				}
				
				System.out.println("This is your current order. Are you sure you want to purchase?"
						+ " Choosing no will reset your order. :^) (yes/no)");

				response = scan.nextLine();

				if (response.equalsIgnoreCase("yes")) {
					System.out.println("Using saved credit card information...");
					buyer.makeOrder();
					buyer.resetOrder();
					System.out.println("Purchase successful!");
				} else if (response.equalsIgnoreCase("no")) {
					buyer.resetOrder();
					continue;
				} else {
					System.out.println("Invalid input!");
					continue;
				}
			}

			else if (Integer.parseInt(choice) == 4) {
				System.out.println("Have a good day!");
				login();
			} // Choice 4 statement
		} // End of while
	}

	public static void ordinaryBuyer() throws IOException {
		while (true) {
			System.out.println(
					"What would you like to do? Please choose one of the following (type number):\n1.Search a book\n"
							+ "2.Subscribe\n" + "3.Purchase\n" + "4.Quit");

			choice = scan.nextLine();
			if (choice.length() > 1) {
				System.out.println("Invalid input. Please try again.");
			} else if (choice.compareTo("1") < 0 || choice.compareTo("5") > 0) {
				System.out.println("Invalid input. Please try again.");
			}

			
			else if (Integer.parseInt(choice) == 1) {
				System.out.println("Please enter name of book:");
				title = scan.nextLine();
				d = buyer.searchCatalog(title);
				
				
				if (d == null) {
					System.out.println("Could not find that title.");
					
				} else {
					System.out.print("Found " + d.getTitle() + "! Price: ");
					System.out.printf("%.2f%n\n",d.getPrice());
					
					System.out.println("Would you like to add " + title + " to your shopping cart? (yes/no)");
					response = scan.nextLine();
					if (response.equals("yes")) {
						buyer.getOrder().addDoc(d);
						d = null;
					}
					else if(response.equals("no")) {
						System.out.println("Adding document canceled.");
						d = null;
					}
					else {
						System.out.println("Invalid input!");
					}
				}
				
				
			} // choice 1 statement

			else if (Integer.parseInt(choice) == 2) {
				scan = new Scanner(System.in);
				System.out.println("Please enter a username:");
				String newname = scan.nextLine();
				System.out.println("Please enter a password:");
				String newpass = scan.nextLine();
				System.out.println("Please enter your email:");
				String newemail = scan.nextLine();
				System.out.println("Please enter your credit card number:");
				long newCredit = Integer.parseInt(scan.nextLine());

				if (!((OrdinaryBuyer) buyer).subscribe(newname, newpass)) {
					System.out.println("Unable to subscribe; username already exists!");
					continue;
				}

				buyer = new RegisteredBuyer(newname, newpass, newemail, newCredit, null);
				System.out.println("You have subscribed!");
				login();
			} // choice 3 statement

			else if (Integer.parseInt(choice) == 3) {
				if(!buyer.showList()) {
					
					System.out.println("You have no orders!");
					continue;
				}
				
				System.out.println("This is your current order. Are you sure you want to purchase?"
						+ " Choosing no will reset your order. :^) (yes/no)");

				response = scan.nextLine();

				if (response.equalsIgnoreCase("yes")) {
					System.out.println("Using saved credit card information...");
					buyer.makeOrder();
					buyer.resetOrder();
					System.out.println("Purchase successful!");
				} else if (response.equalsIgnoreCase("no")) {
					buyer.resetOrder();
					continue;
				} else {
					System.out.println("Invalid input!");
					continue;
				}
			}

			else if (Integer.parseInt(choice) == 4) {
				System.out.println("Have a good day!");
				login();
			}
		} // while loop for ordinary buyer

	}// end ordinary buyer

	public static void login() throws IOException {
		while (true) {

			System.out.println("please enter username. If you are an ordinary buyer, please enter 'ordinary':");
			username = scan.nextLine();
			if (username.equalsIgnoreCase("ordinary")) {
				buyer = new OrdinaryBuyer();
				ordinaryBuyer();
				break;
			}
			System.out.println("Please enter password:");
			password = scan.nextLine();
			BufferedReader reader = new BufferedReader(new FileReader("login.txt"));
			String line = reader.readLine();
			while (line != null) {
				String[] parts = line.split(";");
				if (username.equals(parts[0]) && password.equals(parts[1]) && parts[2].equals("R")) {

					buyer = new RegisteredBuyer(username, password, parts[3], Integer.parseInt(parts[4]), promos);
					registeredBuyer();

					break;
				} else if (username.equals(parts[0]) && password.equals(parts[1]) && parts[2].equals("O")) {
					staff = new Operator(username, password);
					operator();
					break;
				}
				line = reader.readLine();
			}
			reader.close();
			System.out.println("The username and password you entered does not exist.");
		}
	}

	public static void startup() {

		inventory = new Inventory();
		promos = new ArrayList<Promotion>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader("documents.txt"));
			String line = reader.readLine();

			while (line != null) {
				String[] parts = line.split(";");
				Document doc = new Document(Integer.parseInt(parts[0]), parts[1], parts[2],
						Double.parseDouble(parts[3]));
				inventory.add(doc);
				line = reader.readLine();
			}

			for (int i = 0; i < 3; i++) {
				Random rand = new Random();
				ArrayList<Document> temp = inventory.getList();
				int randomIndex = rand.nextInt(temp.size());
				Promotion p = new Promotion(temp.get(randomIndex), (temp.get(randomIndex).getPrice()) * 0.75);
				temp.remove(randomIndex);
				promos.add(p);
			}

			reader.close();
		} catch (IOException e) {

		}

	}

	public static void main(String args[]) throws IOException {

		startup();

		login();
	}// main function

}
