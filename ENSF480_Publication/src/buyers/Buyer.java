package buyers;
import frontend.*;
import shared.*;

public abstract class Buyer {
	
	protected String email;
	protected int creditCard;
	protected boolean isSubscribed;
	protected ArrayList<Order> orders;
	
	public abstract Document searchCatalog();
	
	//maybe this function should be defined for all of them,
	//and just let each buyer have a different way to search
	//the catalog.
	public abstract Order makeOrder();
	
}
