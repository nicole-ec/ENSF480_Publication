package buyers;

import shared.Document;

public class OrdinaryBuyer extends Buyer{

	private boolean isSubscribed;
	private String email;
	private String creditCard;
	
	public OrdinaryBuyer() {
		super();
		isSubscribed = false;
	}
	
	public void subscribe() {
		isSubscribed = true;
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
