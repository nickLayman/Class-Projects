import java.util.*;
import java.text.*;

public class PepsiMachine {
    int stock; //number of bottles in stock
    int totalSales; //total sales for the day in cents
    int currCustomerCredit; //credit the current customer has in cents
    final int price = 150; //price of one bottle of pepsi in cents

    NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);

    public PepsiMachine(int num)    {
        stock = num;
        totalSales = 0;
        currCustomerCredit = 0;

        displayGreeting();
    }

    public void displayGreeting ( )  {
        if (stock > 0){
            System.out.println("Ice cold drinks!");
            System.out.println("Price: " + fmt.format((double) price / 100));
        }
        else{
            System.out.println("Sorry. Out of stock.");
            System.out.println("Please try again later.");
        }
    }

    public int getPrice ( )  {
        return price;
    }

    public int getInventory ( ) {
        return stock;
    }

    public int getCredit ( ) {
        return currCustomerCredit;
    }

    public int getTotalSales ( ) {
        return totalSales;
    }

    public void insertCoin (int amount ) {
        if ((amount == 5 || amount == 10 || amount == 25 
            || amount == 50 || amount == 100) && stock > 0)
            currCustomerCredit += amount;

        if (stock <= 0)
            displayGreeting();

        if (currCustomerCredit < price){
            System.out.println("Credit: " + fmt.format((double) currCustomerCredit / 100));
            System.out.println("Price: " + fmt.format((double) price / 100));
        }
        else{
            System.out.println("Please...");
            System.out.println("Make a Selection");
        }

    }

    public void makeSelection ( ) {
        if (currCustomerCredit < price){
            System.out.println("Credit: " + fmt.format((double) currCustomerCredit / 100));
            System.out.println("Price: " + fmt.format((double) price / 100));
        } else{
            stock--;
            totalSales += price;
            currCustomerCredit = 0;

            System.out.println("Now dispensing...");
            System.out.println("Your Pepsi");
        }
    }

    public void restock (int units ) {
        if (units > 0)
            stock += units;
    }

    public void showReport ( ) {
        System.out.println("Inventory: " + stock);
        System.out.println("Total Sales: " + fmt.format((double) totalSales / 100));
    }

    public void cancelPurchase () {
        currCustomerCredit = 0;

        displayGreeting();
    }

    public void multipleSales (int num)  {
        for (int i = 0; i < num; i++){
            insertCoin(5);
            insertCoin(25);
            insertCoin(25);
            insertCoin(100);
            
            makeSelection();
        }
        
        showReport();
    }

    public void multipleRandomSales ()  {
        Random rand = new Random();
        
        int num = rand.nextInt(6) + 5;
        
        for (int i = 0; i < num; i++){
            insertCoin(5);
            insertCoin(25);
            insertCoin(25);
            insertCoin(100);
            
            makeSelection();
        }
        
        showReport();
    }

    public static void main () {
        PepsiMachine cis = new PepsiMachine (10);
        cis.multipleSales(10);
        
        PepsiMachine mine = new PepsiMachine(1);
        System.out.println("should be invalid");
        mine.insertCoin(0);
        mine.insertCoin(-5);
        mine.insertCoin(15);
        mine.insertCoin(1);
        System.out.println();
        
        System.out.println("should be valid");
        mine.insertCoin(5);
        mine.insertCoin(10);
        mine.insertCoin(25);
        mine.insertCoin(50);
        mine.insertCoin(100);
        mine.insertCoin(10);
        System.out.println();
        
        System.out.println("should be valid");
        mine.makeSelection();
        mine.showReport();
        mine.restock(9);
        mine.showReport();
        System.out.println();
        
        System.out.println("should do nothing");
        mine.showReport();
        mine.restock(-1);
        mine.restock(0);
        mine.showReport();
    }
}
