package test;

import staff.*;
import buyers.*;
import shared.*;

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
	private static String username, password, title = null, response, author;
	private static Buyer buyer;
	private static Staff staff;
	private static Document d = null;
	private static String choice;
	private static int isbn;
	private static double price;
	private static ArrayList<Promotion> promos;
	private static Inventory inventory;

	public static int takeIsbnInput() {
		do {
			System.out.println("Please enter isbn number of the document you would like to add:");

			while (!scan.hasNextInt()) {
				scan.next();
				System.out.println("Please enter a 9 digit number:");
			}
			isbn = scan.nextInt();
		} while (Integer.toString(isbn).length() != 9);
		return isbn;
	}

//	private static void updateDoc(String[] parts, boolean authorUpdate, boolean titleUpdate, boolean priceUpdate)
//			throws IOException {
//		if (titleUpdate == true && authorUpdate == true && priceUpdate == true) {
//			d = new Document(isbn, title, author, price);
//			((Operator) staff).updateDoc(d);
//		} else if (titleUpdate == true && authorUpdate == true && priceUpdate == false) {
//			price = Double.parseDouble(parts[3]);
//			d = new Document(isbn, title, author, price);
//			((Operator) staff).updateDoc(d);
//		} else if (titleUpdate == true && authorUpdate == false && priceUpdate == true) {
//			author = parts[2];
//			d = new Document(isbn, title, author, price);
//			((Operator) staff).updateDoc(d);
//		} else if (titleUpdate == false && authorUpdate == true && priceUpdate == true) {
//			title = parts[1];
//			d = new Document(isbn, title, author, price);
//			((Operator) staff).updateDoc(d);
//		} else if (titleUpdate == true && authorUpdate == false && priceUpdate == false) {
//			author = parts[2];
//			price = Double.parseDouble(parts[3]);
//			d = new Document(isbn, title, author, price);
//			((Operator) staff).updateDoc(d);
//		} else if (titleUpdate == false && authorUpdate == true && priceUpdate == false) {
//			title = parts[1];
//			price = Double.parseDouble(parts[3]);
//			d = new Document(isbn, title, author, price);
//			((Operator) staff).updateDoc(d);
//		} else if (titleUpdate == false && authorUpdate == false && priceUpdate == true) {
//			author = parts[2];
//			title = parts[1];
//			d = new Document(isbn, title, author, price);
//			((Operator) staff).updateDoc(d);
//		} else if (titleUpdate == false && authorUpdate == false && priceUpdate == false) {
//			d = new Document(isbn, title, author, price);
//			((Operator) staff).updateDoc(d);
//		}
//	}

	public static int choices() throws IOException {
		
		int option;
		scan = new Scanner(System.in);
		do {
			System.out.println("Please select what you would like to change: " + "\n1.Update title" + "\n2.Update author"
				+ "\n3.Update price" + "\n4.Quit");

			while (!scan.hasNextInt()) {
				scan.next();
				System.out.println("Please enter a valid input:");
			}
			option = scan.nextInt();
		} while (option<0 && option>4);
		
		return option;

	}

	public static void index(int number)
	{
		int i=0;
		do
		{
		 System.out.println(inventory.getList().size()+" "+number+" "+inventory.getItem(i).getIsbn());
			if (number == inventory.getItem(i).getIsbn()) {
				System.out.println("This isbn number already exists! Please choose another number.");
				number = takeIsbnInput();
		}
			i++;
		}while(i<inventory.getList().size());
	}
	
	public static void operator() throws IOException {
		int chooseOption;
		while (true) {
			System.out.println("What would you like to do? Please choose one of the following:\n1.Add a document\n"
					+ "2.Remove a document\n" + "3.Update a document\n" + "4.Quit\n");
			
			do {
				System.out.println("Please choose a valid input: ");
				while (!scan.hasNextInt()) {
					scan.next();
					System.out.println("Please enter a valid input:");
				}
				
				chooseOption = scan.nextInt();
			} while (chooseOption < 1 && chooseOption > 4);
			 if (chooseOption == 1) {
				 int number;
				 number = takeIsbnInput();
				 	 
				 
				 int i=0;
				 do {
						if (number == inventory.getItem(i).getIsbn()) {
							System.out.println("This isbn number already exists! Please choose another number.");
							number = takeIsbnInput();
							index(number);
						}
						i++;
				 }while(i<inventory.getList().size());
				 
				 
//					BufferedReader reader = new BufferedReader(new FileReader("documents.txt"));
//					String line = reader.readLine();
//					
//					while (line != null) {
//						
//						if (line.isEmpty()) {
//							line = reader.readLine();
//							continue;
//						}
//						
//						String[] parts = line.split(";");
//						if (number == Integer.parseInt(parts[0])) {
//							
//							System.out.println("This isbn number already exists! Please choose another number.");
//							takeIsbnInput();
//							break;
//						}
//						line = reader.readLine();
//					}
//					reader.close();
				scan = new Scanner(System.in);
				System.out.println("Please enter title of document you would like to add:");
				title = scan.nextLine();
				System.out.println("Please enter the author of the document you would like to add:");
				author = scan.nextLine();
				System.out.println("Please enter price of the document you would like to add:");
				
				while(!scan.hasNextDouble()) {
					scan.next();
					System.out.println("Please enter a valid price:");
				}
				price = scan.nextDouble();
				if(price <= 0) {
					System.out.println("Invalid price!!\n");
					continue;
				}
				d = new Document(isbn, title, author, price);
				inventory = ((Operator) staff).addDoc(d, inventory);
				System.out.println("Document added successfully!");
				
			} // choice 1 statement

			else if (chooseOption == 2) {
				do {
					System.out.println("Please enter isbn number of the document you would like to remove:");
					
					while(!scan.hasNextInt()) {
						scan.next();
						System.out.println("Please enter a 9 digit number:");
					}
					isbn = scan.nextInt();
				}while(Integer.toString(isbn).length() != 9);
				
				boolean removed = false;
				
				for (int i=0; i<inventory.getList().size(); i++) {
					if (isbn == inventory.getItem(i).getIsbn()) {
						inventory = ((Operator) staff).removeDoc(i, isbn, inventory);
						System.out.println("Document is removed");
						removed = true;
						break;
					}
				}
				
				if(!removed) {
					System.out.println("The isbn number you entered does not exist.");
				}
				
//				BufferedReader reader = new BufferedReader(new FileReader("documents.txt"));
//				String line = reader.readLine();
//				while (line != null) {
//					
//					if (line.isEmpty()) {
//						line = reader.readLine();
//						continue;
//					}
//					
//					String[] parts = line.split(";");
//					if (Integer.toString(isbn).equals(parts[0])) {
//						((Operator) staff).removeDoc(isbn);
//						d = null;
//						System.out.println("Document is removed");
//						break;
//					}
//					line = reader.readLine();
//				}
//				reader.close();
//				if(line == null)
//					System.out.println("The isbn number you entered does not exist.");
			} // choice 2 if statement

			else if (chooseOption == 3) {
				do {
					System.out.println("Please enter isbn number of the document you would like to update:");

					while (!scan.hasNextInt()) {
						scan.next();
						System.out.println("Please enter a 9 digit number:");
					}
					isbn = scan.nextInt();
				} while (Integer.toString(isbn).length() != 9);

				boolean found = false;

				for (int i = 0; i < inventory.getList().size(); i++) {
					if (isbn == inventory.getItem(i).getIsbn()) {
						found = true;
						Document temp = inventory.getItem(i);
						System.out.println("Author is " + temp.getAuthor());
						int option = choices();

						while (option <= 4) {
							if (option == 1) {
								scan = new Scanner(System.in);
								System.out.println("Please enter what you would like to change the title to:");
								title = scan.nextLine();
								temp.setTitle(title);
								System.out.println(title);
								option = choices();

							} else if (option == 2) {
								scan = new Scanner(System.in);
								System.out.println("Please enter the what you would like to update author to:");
								author = scan.nextLine();
								temp.setAuthor(author);
								option = choices();

							} else if (option == 3) {
								scan = new Scanner(System.in);
								System.out.println("Please enter what you would like to change the price to:");

								while (!scan.hasNextDouble()) {
									scan.next();
									System.out.println("Please enter a valid price:");
								}
								price = scan.nextDouble();
								temp.setPrice(price);
								System.out.println("success");
								option = choices();

							} else if (option == 4) {

								inventory = ((Operator) staff).updateDoc(i, temp, inventory);

								System.out.println("Have a good day!");
								login();
							}
						}

						System.out.println("Document is updated");
						break;
					}
				}

				if (!found) {
					System.out.println("The isbn number you entered does not exist.");
				}
				
//				BufferedReader reader = new BufferedReader(new FileReader("documents.txt"));
//				String line = reader.readLine();
//				boolean titleUpdate = false;
//				boolean authorUpdate = false;
//				boolean priceUpdate = false;
//				
//				while (line != null) {
//					
//					if (line.isEmpty()) {
//						line = reader.readLine();
//						continue;
//					}
//					
//					String[] parts = line.split(";");
//					if (Integer.toString(isbn).equals(parts[0])) {
//
//						int option;
//						option = choices();
//						while (option <= 4) {
//							if (option == 1) {
//								scan = new Scanner(System.in);
//								System.out.println("Please enter what you would like to change the title to:");
//								title = scan.nextLine();
//								titleUpdate = true;
//								System.out.println(title);
//								option = choices();
//							
//
//							} else if (option == 2) {
//								scan = new Scanner(System.in);
//								System.out.println("Please enter the what you would like to update author to:");
//								author = scan.nextLine();
//								authorUpdate = true;
//								option = choices();
//								
//							} else if (option == 3) {
//								scan = new Scanner(System.in);
//								System.out.println("Please enter what you would like to change the price to:");
//
//								while(!scan.hasNextDouble()) {
//									scan.next();
//									System.out.println("Please enter a valid price:");
//								}
//								price = scan.nextDouble();
//								priceUpdate = true;
//								System.out.println("success");
//								option = choices();
//								
//						
//							} else if (option == 4) {
//								
//								updateDoc(parts, authorUpdate, titleUpdate, priceUpdate);
//								
//								System.out.println("Have a good day!");
//								login();
//								break;
//							}
//						}
//						
//						break;
//					}
//					
//					line = reader.readLine();
//				}
//			
//					System.out.println("This number does not exist in the inventory.");
//			
//				reader.close();
			} // choice 3 statement
			else if (chooseOption == 4) {
				System.out.println("Have a good day!");
				login();
			} // Choice 4 statement
		} // End of while

	}

	public static void registeredBuyer() throws IOException {

		while (true) {
			System.out.println("What would you like to do? Please choose one of the following:\n1.Search a book\n"
					+ "2.Unsubscribe\n" + "3.Purchase\n" + "4.Quit");
			choice = scan.nextLine();

			if (choice.length() > 1) {
				System.out.println("Invalid input. Please try again.");
			} else if (choice.compareTo("1") < 0 || choice.compareTo("4") > 0) {
				System.out.println("Invalid input. Please try again.");
			}

			else if (Integer.parseInt(choice) == 1) {
				System.out.println("Please enter name of book:");
				title = scan.nextLine();
				d = buyer.searchCatalog(title, inventory);

				if (d == null) {
					System.out.println("Could not find that title.");

				} else {
					System.out.print("Found " + d.getTitle() + "! Price: ");
					System.out.printf("%.2f%n\n", d.getPrice());

					System.out.println("Would you like to add " + title + " to your shopping cart? (yes/no)");
					response = scan.nextLine();
					if (response.equals("yes")) {
						buyer.getOrder().addDoc(d);
						d = null;
					} else if (response.equals("no")) {
						System.out.println("Adding document canceled.");
						d = null;
					} else {
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
				if (!buyer.showList()) {

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
					System.out.println("Cleared order successfully!");
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
		int buyChoice;
		while (true) {
			System.out.println(
					"What would you like to do? Please choose one of the following (type number):\n1.Search a book\n"
							+ "2.Subscribe\n" + "3.Purchase\n" + "4.Quit");

			while(!scan.hasNextInt()) {
				scan.next();
				System.out.println("Please enter a valid choice:");
			}
			buyChoice= scan.nextInt();
			scan = new Scanner(System.in);
			
			if (buyChoice == 1) {
				System.out.println("Please enter name of book:");
				title = scan.nextLine();
				d = buyer.searchCatalog(title, inventory);

				if (d == null) {
					System.out.println("Could not find that title.");

				} else {
					System.out.print("Found " + d.getTitle() + "! Price: ");
					System.out.printf("%.2f%n\n", d.getPrice());

					System.out.println("Would you like to add " + title + " to your shopping cart? (yes/no)");
					response = scan.nextLine();
					if (response.equals("yes")) {
						buyer.getOrder().addDoc(d);
						d = null;
					} else if (response.equals("no")) {
						System.out.println("Adding document canceled.");
						d = null;
					} else {
						System.out.println("Invalid input!");
					}
				}

			} // choice 1 statement

			else if (buyChoice == 2) {
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

			else if (buyChoice == 3) {
				if (!buyer.showList()) {

					System.out.println("You have no orders!");
					continue;
				}

				System.out.println("This is your current order. Are you sure you want to purchase?"
						+ " Choosing no will reset your order. :^) (yes/no)");

				response = scan.nextLine();

				if (response.equalsIgnoreCase("yes")) {
					System.out.println("Please enter your email address:");
					String email = scan.nextLine();
					buyer.getOrder().setEmail(email);
					
					int cardnum;
					do {
						System.out.println("Please enter your credit card number:");
						
						while(!scan.hasNextInt()) {
							scan.next();
							System.out.println("Please enter a 9 digit number:");
						}
						cardnum = scan.nextInt();
					}while(Integer.toString(cardnum).length() != 9);
					buyer.getOrder().setCreditCard(cardnum);
					
					buyer.makeOrder();
					buyer.resetOrder();
					System.out.println("Purchase successful!");
				} else if (response.equalsIgnoreCase("no")) {
					buyer.resetOrder();
					System.out.println("Cleared order successfully!");
					continue;
				} else {
					System.out.println("Invalid input!");
					continue;
				}
			}

			else if (buyChoice == 4) {
				System.out.println("Have a good day!");
				login();
			}
			else {
				System.out.println("Please enter a valid choice:");
			}
		} // while loop for ordinary buyer

	}// end ordinary buyer

	public static void login() throws IOException {
		while (true) {
			scan = new Scanner(System.in);
			System.out.println("Please enter username. If you are an ordinary buyer, please enter 'ordinary':");
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
					buyer.getOrder().setEmail(parts[3]);
					buyer.getOrder().setCreditCard(Integer.parseInt(parts[4]));
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
				
				if (line.isEmpty()) {
					line = reader.readLine();
					continue;
				}
				
				
				String[] parts = line.split(";");
				Document doc = new Document(Integer.parseInt(parts[0]), parts[1], parts[2],
						Double.parseDouble(parts[3]));
				inventory.add(doc);
				line = reader.readLine();
			}
			
			
			for (int i = 0; i < 3; i++) {
				Random rand = new Random();
				ArrayList<Document> temp = new ArrayList();
				temp.add(inventory.getItem(i));
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
		System.out
				.println("\n\n========================= Welcome to Unlimited Publications Agency =========================\n\n");
		login();
	}// main function

}
