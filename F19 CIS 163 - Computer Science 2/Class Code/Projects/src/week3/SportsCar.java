package week4;

public class SportsCar extends Car {
	
	private String specialName;
	private boolean turboCharged;
	private int horsePower;
	
	public SportsCar (String specialName, boolean turboCharged,
					   int horsePower, String name, double engSize) {
	
	super();
	this.specialName = specialName;
	this.turboCharged = turboCharged;
	horsePower = 200;
	super.horsePower= 12;

	}
	
	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
		super.horsePower = 40;
		super.setHorsePower(40);
		turboCharged = true;
	}
	
	public SportsCar() {
		setHorsePower(1200);
	}
	
    public SportsCar (String specialName, double EngSize) {
    	super(EngSize);
  //  	engSize = EngSize;
    	
    }
	
	public void setDefaultHorsePower () {
		horsePower = 200;
	//	super.horsePower = 100;
	}
}










