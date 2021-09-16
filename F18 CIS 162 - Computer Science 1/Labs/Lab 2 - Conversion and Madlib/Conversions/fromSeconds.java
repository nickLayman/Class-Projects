import java.util.*;

/**
 * Write a description of class test here.
 *
 * @author (Nick Layman)
 * @version (09/01/2018)
 */

public class fromSeconds {
   public static void main(String[] args) {
      
      int numSeconds;
      int numMinutes;
      int numHours;
      
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Seconds: ");
      numSeconds = scan.nextInt();
      
      numHours = numSeconds / 3600;
      numMinutes = (numSeconds % 3600) / 60;
      numSeconds %= 60;
      
      System.out.println("Hours: " + numHours);
      System.out.println("Minutes: " + numMinutes);
      System.out.println("Seconds: " + numSeconds);
      
   }
}
