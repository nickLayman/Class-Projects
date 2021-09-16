package week1;

public class Example {
	public static void doIt(Counter c1, Counter c2) {
		c1 = new Counter(6);
//		c2 = new Counter(8);
		c1.incr();
		c2.incr();
		c1.incr();
		c2.incr();
	}

	public static void main(String[] args) {
		Counter c1 = new Counter(3);	
		Counter c2 = new Counter(4);	
		doIt(c1, c2);
		System.out.println("Line 1: " + " " + c2);		
		c1 = new Counter(3);
		c2 = new Counter(5);
		
	//	if (c1 .getValue()== c2.getValue())
			
		
		doIt(c2, c1);
		System.out.println("Line 2: " + c1 + " " + c2);
//		doIt(c1, c1);
//		System.out.println("Line 3: " + c1 + " " + c2);
//		doIt(c2, c2);
//		System.out.println("Line 4: " + c1 + " " + c2);
	}

	//	   Output: 	Line 1: ___________________
	//
	//			Line 2: ___________________
	//
	//			Line 3: ___________________
	//
	//			Line 4: ___________________

	/*
	 * 
	 * 
	 *
	Line 1:  6
    Line 2: 5 5 
	 * 
	 */
	
}
