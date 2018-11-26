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
	public Document searchCatalog(String title) {
		// TODO Auto-generated method stub
		for(int i=0; i<inventory.getList().size(); i++) {
			if(inventory.getItem(i).getTitle().equalsIgnoreCase(title)) {
				return inventory.getItem(i);
			}
		}
		System.out.println("Could not find: "+title);
		return null;
	}

	@Override
	public Order makeOrder(Document d) {
		// TODO Auto-generated method stub
		double totalPrice = order.calculateTotal();
		
		System.out.println("===============================RECEIPT===============================");
		
		
		
		return null;
	}

}
