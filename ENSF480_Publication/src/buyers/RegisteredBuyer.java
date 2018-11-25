package buyers;

import java.util.ArrayList;

import shared.Document;

public class RegisteredBuyer extends Buyer{

	private String username;
	private String password;
	private ArrayList<Promotion> promo;
	
	public RegisteredBuyer(String email, int creditCard, String username, String password) {
		super(email, creditCard);
		isSubscribed = true;
		this.username = username;
		this.password = password;
	}
	
	public void unsubscribe() {
		
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
