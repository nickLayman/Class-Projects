package week1;

public class Counter {
	private int value;

	public Counter(int number) {
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
	
	public boolean equals(Counter pizza) {
		if (pizza.value == this.value)
			return true;
		else 
			return false;
		
	}
}
