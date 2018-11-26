package buyers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import shared.Document;

public class RegisteredBuyer extends Buyer{
	
	private String email;
	private String creditCard;
	private String username;
	private String password;
	private ArrayList<Promotion> promo;
	
	public RegisteredBuyer(String email, String creditCard, String username, String password, ArrayList<Promotion> promo) {
		super();
		isSubscribed = true;
		this.email = email;
		this.creditCard = creditCard;
		this.username = username;
		this.password = password;
		this.promo = promo;
	}
	
	public void unsubscribe() {
		isSubscribed = false; 
		String fileName = "login.txt";
		String lineToRemove = "username";	
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.filter(line->!line.trim().equals(lineToRemove)).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addPromo(Promotion p) {
		promo.add(p);
	}
	
	@Override
	public Document searchCatalog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order makeOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
