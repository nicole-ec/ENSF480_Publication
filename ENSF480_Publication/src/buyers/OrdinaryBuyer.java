package buyers;

import shared.Document;

public class OrdinaryBuyer extends Buyer{

	public OrdinaryBuyer(String email, int creditCard) {
		super(email, creditCard);
		isSubscribed = false;
	}
	
	public void subscribe() {
		
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
