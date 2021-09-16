import java.util.*;

/**
 * Write a description of class test here.
 *
 * @author (Nick Layman)
 * @version (09/01/2018)
 */

public class toSeconds {
   public static void main(String[] args) {
      int numSeconds;
      Scanner scan = new Scanner(System.in);
      
      System.out.print("Hours: ");
      numSeconds = 3600 * scan.nextInt();
      System.out.print("Minutes: ");
      numSeconds += 60 * scan.nextInt();
      System.out.print("Seconds: ");
      numSeconds += scan.nextInt();
      
      System.out.println(numSeconds + " seconds");
   }
}
