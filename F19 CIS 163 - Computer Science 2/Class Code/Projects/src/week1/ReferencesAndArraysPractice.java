package week1;

public class ReferencesAndArraysPractice {
	public static void practiceArrayProblem() {
		Counter[] arrayA = { new Counter(0), new Counter(10), new Counter(20), new Counter(30) };
		Counter[] arrayB = new Counter[arrayA.length];
		Counter[] arrayC = new Counter[arrayB.length];
		System.out.println("Line 1: " + arrayA[1] + " " + arrayB[1] + " " + arrayC[1]);
		
		// ****** S T O P  N O W ***********
		
		arrayB = arrayA;
		for (int x = 0; x < arrayB.length; x++) {
			arrayC[x] = new Counter(arrayB[x].getValue());
		}
		System.out.println("Line 2: " + arrayA[1] + " " + arrayB[1] + " " + arrayC[1]);
		
		// ****** S T O P  N O W ***********
		
		arrayA[1].incr();
		arrayB[1].incr();
		arrayC[1].incr();
		System.out.println("Line 3: " + arrayA[1] + " " + arrayB[1] + " " + arrayC[1]);
		System.out.println("Line 4: " + arrayA[2] + " " + arrayB[2] + " " + arrayC[2]);
		
		// ****** S T O P  N O W ***********
			
		arrayA[3] = new Counter(100);
		arrayB[3] = new Counter(200);
		arrayC[3] = new Counter(300);
		arrayA[3].incr();
		arrayB[3].incr();
		arrayC[3].incr();
		System.out.println("Line 5: " + arrayA[3] + " " + arrayB[3] + " "+ arrayC[3]);
	}
	
	public static void main(String[] args) {
		practiceArrayProblem();
	}
}
