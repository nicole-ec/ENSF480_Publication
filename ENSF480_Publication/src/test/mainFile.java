package test;

import staff.*;
import buyers.*;
import shared.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class mainFile {
	
	private static Scanner scan = new Scanner(System.in);
	private static String username, password, title = null, response;
	private static Buyer buyer;
	private static Staff staff;
	private static Document d = null;
	private static int choice;
	
	
	public static void registeredBuyer() throws IOException
	{
		while (true) {
			System.out.println("What would you like to do? Please choose one of the following:\n1.Search a book\n"
					+ "2.Place an order\n" + "3.Unsubscribe\n"+"4.Quit\n");
			choice = Integer.parseInt(scan.nextLine());				
			
			if(choice == 1) {
				System.out.println("Please enter name of book:");
				title = scan.nextLine();
				d = buyer.searchCatalog(title);
				if(d == null) {
					System.out.println("Could not find that title.");
					continue;
				}
				else {
					System.out.println("Found "+title+"!");
				}
			}//choice 1 statement
			
			else if(choice == 2) {
				if(d == null) {
					System.out.println("Please choose a document first!");
					continue;
				}
				else {
					System.out.println("Would you like to buy "+title+"? (yes/no)");
					response = scan.nextLine();
					if(response.equals("yes")) {
						buyer.getOrder().addDoc(d);
						d = null;
						continue;
					}
				}
			}//choice 2 if statement
			
			if(choice == 3) {
				scan = new Scanner(System.in);
				((RegisteredBuyer)buyer).unsubscribe();
				System.out.println("You have unsubscribed!");
				
			}//choice 3 statement
			
			else if(choice == 4) {
				System.out.println("Have a good day!");
				login();
			}// Choice 4 statement
		}// End of while    
	}
	
	
	public static void login() throws IOException {
		while (true) {
		
			System.out.println("please enter username. If you are an ordinary buyer, please enter 'ordinary':");
			username = scan.nextLine();
			if (username.equalsIgnoreCase("ordinary")) {
				buyer = new OrdinaryBuyer();
				break;
			}
			System.out.println("Please enter password:");
			password = scan.nextLine();
			BufferedReader reader = new BufferedReader(new FileReader("login.txt"));
			String line = reader.readLine();
			while(line!=null)
			{
				String[] parts = line.split(";");
				if(username.equals(parts[0]) && password.equals(parts[1]))
				{
					buyer = new RegisteredBuyer(username,password);
					registeredBuyer();
					break;
				}
				line = reader.readLine();
			}
			reader.close();
			
		
			
			
			
		}
	}

	public static void main(String args[]) throws IOException {
		
		login();

		if (username.equals("ordinary")) {
			
			while (true) {
				System.out.println("What would you like to do? Please choose one of the following:\n1.Search a book\n"
						+ "2.Place an order\n" + "3.Subscribe\n"+"4.Quit\n");
				
				choice = Integer.parseInt(scan.nextLine());				
				
				if(choice == 1) {
					System.out.println("Please enter name of book:");
					title = scan.nextLine();
					d = buyer.searchCatalog(title);
					if(d == null) {
						System.out.println("Could not find that title.");
						continue;
					}
					else {
						System.out.println("Found "+title+"!");
					}
				}//choice 1 statement
				
				else if(choice == 2) {
					if(d == null) {
						System.out.println("Please choose a document first!");
						continue;
					}
					else {
						System.out.println("Would you like to buy "+title+"? (yes/no)");
						response = scan.nextLine();
						if(response.equals("yes")) {
							buyer.getOrder().addDoc(d);
							d = null;
							continue;
						}
					}
				}//choice 2 if statement
				
				if(choice == 3) {
					scan = new Scanner(System.in);
					System.out.println("Please enter a username:");
					String newname = scan.nextLine();
					System.out.println("Please enter a password:");
					String newpass = scan.nextLine();
					System.out.println("Please enter your email:");
					String newemail = scan.nextLine();
					System.out.println("Please enter your credit card number:");
					String newCredit = scan.nextLine();
					
					
					if(!((OrdinaryBuyer) buyer).subscribe(newname, newpass)) {
						System.out.println("Unable to subscribe; username already exists!");
						continue;
					}
					
					buyer = new RegisteredBuyer(newname, newpass, newemail, newCredit, null);
					System.out.println("You have subscribed!");
					
				}//choice 3 statement
				
				else if(choice == 4) {
					System.out.println("Have a good day!");
					login();
				}
			}//while loop for ordinary buyer
		}//ordinary buyer if statement
	}//main function

}
