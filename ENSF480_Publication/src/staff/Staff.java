package staff;
import java.util.ArrayList;

import shared.*;

public abstract class Staff {
	protected String name;
	protected String username;
	protected String password; 
	
	public Staff(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}


}
