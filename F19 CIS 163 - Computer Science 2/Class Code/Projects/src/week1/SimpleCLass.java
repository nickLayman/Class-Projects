package week1;

public class SimpleCLass {
	private int value;

	public SimpleCLass(int number) {
		value = number;
	}

	public String toString() {
		return "" + value;
	}

	public void incr() {
		value++;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public boolean equals(SimpleCLass pizza) {
        return pizza.value == this.value;
		
	}
}
