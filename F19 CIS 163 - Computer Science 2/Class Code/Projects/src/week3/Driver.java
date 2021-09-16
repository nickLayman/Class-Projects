package week4;

import javax.swing.JFrame;

public class Driver {

	public static void main (String[] args) {
		
		Car c = new Car();
		SportsCar s = new SportsCar();
		Object o;
	    s.setHorsePower(200);
	    c.setHorsePower(40);
	    
	    
	    c = s;
	    c.setHorsePower(40);
	    
	    
//	    s = c;
	    o = c;
	    o = s;
	    
	
	    
	    		
	}
}
