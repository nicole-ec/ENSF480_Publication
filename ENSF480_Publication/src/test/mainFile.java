package test;

import staff.*;
import buyers.*;
import java.util.Scanner;

public class mainFile {
	
	public static void main(String args []) {
		
		Scanner scan = new Scanner(System.in);
		String username, password;
		Buyer buyer;
		
		
		while(true) {
			
			System.out.println("please enter username. If you are an ordinary buyer, please enter 'ordinary':");
			username = scan.nextLine();
			if(username.equalsIgnoreCase("ordinary")) {
				buyer = new OrdinaryBuyer();
			}
			System.out.println("Please enter password:");
			
		}
		
	}

}
