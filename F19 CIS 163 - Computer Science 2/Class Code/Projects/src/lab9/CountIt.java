package lab9;

public class CountIt {
    public int linearLoop(int N) {

        int x = 0;
        int count = 0;
        x++;
        while (count < N) {
            x++;   // while loop
            x++;   // stmt
            System.out.println(".");
            x++;    // i++
            count++;
        }
        x++;
        return x;
    }

    public static void main1(String[] args) {
        CountIt ex = new CountIt();
        int N = 40000;
        long start = System.currentTimeMillis();
        System.out.println ("x = " + ex.linearLoop(N));
        Long endTime = System.currentTimeMillis();
        System.out.println(
                "\nN = " + N + ". Loops ran in: " + (endTime - start));
    }


    public long SnippetNestedLoop(long n) {
        long i, j, x = 0;
        i = 0;  x++;
        while (i < n) {  x++;    			// i < n
            x++;    				// SomeStatement
            j = 0; 	x++;      			// j = 0;
            while (j < n) { x++;   		// j < n
                x++;   			// SomeStatement
                j++; x++;   		// j++;
            }
            x++; 				// Can you explain why is this here?
            i++;  x++;  			// i++;
        }
        x++; 					// Can you explain why is this here? Ans: i < n
        return x;
    }

    public static void main2(String[] args) {
        CountIt r = new CountIt();
        Long t = System.currentTimeMillis();
        System.out.println("x = " + r.SnippetNestedLoop(1000));
        System.out.println ("Time:" + (System.currentTimeMillis() - t));
    }


    public long SnippetLog(long n) {
        long i, j, x = 0;

        i = 1;  x++;
        while (i < n) {	x++;
            x++;  			// SomeStatement
            i = i * 2;  x++;
        }
        x++; 				// Can you explain why is this here?
        return x;
    }

    public static void main3(String[] args) {
        CountIt r = new CountIt();
        Long t = System.currentTimeMillis();
        System.out.println("x = " + r. SnippetLog (1000));
        System.out.println ("Time:" + (System.currentTimeMillis() - t));
    }


    private long fib(int n) {
        if (n < 3)
            return 1;
		else
            return fib(n - 1) + fib (n - 2);
    }

    public static void main(String[] args) {
        CountIt r = new CountIt();
        Long t = System.currentTimeMillis();
        for (int i = 1; i < 10; i++) {
            int N = i;
            System.out.println("Fib of " + N + " = " + r.fib(N));
            System.out.println("Time:" + (System.currentTimeMillis() - t));
        }
    }
}