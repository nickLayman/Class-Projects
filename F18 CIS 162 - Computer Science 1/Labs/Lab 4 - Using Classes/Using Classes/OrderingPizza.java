import java.text.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * Write a description of class OrderingPizza here.
 *
 * @author (Nick Layman)
 * @version (9/18/2018)
 */

public class OrderingPizza{
    public static void main(){
        NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);
        Scanner scan = new Scanner(System.in);
        int numPizzas;
        final double PIZZA_PRICE = 9.99;
        final double SALES_TAX = .06;
        double subTotal;
        double Total;
        
        System.out.println("How many pizzas?");
        numPizzas = scan.nextInt();
        
        subTotal = numPizzas * PIZZA_PRICE;
        Total = subTotal * (1 + SALES_TAX);
        
        System.out.println("Sub Total: " + fmt.format(subTotal));
        System.out.println("Total Due: " + fmt.format(Total));
    }
}
