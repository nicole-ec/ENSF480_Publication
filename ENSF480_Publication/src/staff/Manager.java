package staff;

public class Manager extends Staff{
	public Manager(String name, String username, String password) {
		super(username, password);
	}	
	
	boolean checkInventoryExists() {
		
		return false;
		
	}
	
}
