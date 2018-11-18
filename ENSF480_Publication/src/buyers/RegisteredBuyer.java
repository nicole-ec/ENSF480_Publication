package buyers;

import java.util.ArrayList;

public class RegisteredBuyer extends Buyer{

	private String username;
	private String password;
	private ArrayList<Promotion> promo;
	
	public RegisteredBuyer() {
		
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
