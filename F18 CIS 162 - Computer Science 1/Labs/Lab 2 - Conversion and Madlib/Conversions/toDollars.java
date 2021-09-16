import java.util.Scanner;

/**
 * Write a description of class test here.
 *
 * @author (Nick Layman)
 * @version (09/01/2018)
 */

public class toDollars {
   public static void main(String[] args) {
      double totalAmount;
      int numQuarters;
      int numDimes;
      int numNickels;
      int numPennies;
      
      Scanner scan = new Scanner(System.in);
      
      System.out.print("Quarters: ");
      numQuarters = scan.nextInt();
      System.out.print("Dimes: ");
      numDimes = scan.nextInt();
      System.out.print("Nickels: ");
      numNickels = scan.nextInt();
      System.out.print("Pennies: ");
      numPennies = scan.nextInt();
      
      totalAmount = (25 * numQuarters + 10 * numDimes + 5 * numNickels + numPennies) / 100.0;
      
      System.out.println("Dollars: $" + totalAmount);

   }
}
