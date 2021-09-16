import java.util.Locale;
import java.text.NumberFormat;

/********************************************************************
 * Acts as a self-serve kiosk at a grocery store: can scan items and
 * coupons, make payments, and report daily sales
 * 
 * @author Nick Layman
 * @version 10/3/2018
 *******************************************************************/

public class SelfPayKiosk{
    /** current amount due by current customer */
    private double amountDue;
    
    /** total sales for the day - sum of all customer transactions */
    private double totalSales;
    
    /** total number of customers so far in the day */
    private int numCustomers;
    
    /** name of the store/kiosk */
    private String storeName;
    
    /** sales tax rate for all transactions */
    private final double TAX_RATE = .06;
    
    /** format method used for displaying US Dollar amounts */
    NumberFormat money = NumberFormat.getCurrencyInstance(Locale.US);
    // example: System.out.println("Cost: " + money.format(amount));
    
    
    /*****************************************************
     * Constructor creates a new kiosk with specified name
     * and displays a welcome message with the store name
     * @param name the name of the store/kiosk
     ****************************************************/
    public SelfPayKiosk(String name){
        amountDue = 0.00;
        totalSales = 0.00;
        numCustomers = 0;
        storeName = name;
        
        System.out.println("Welcome to " + storeName + "!");
    }
    
    
    /*************************************
     * Default cunstructor creates a kiosk 
     * with the name "GVSU Corner Store"
     ************************************/
    public SelfPayKiosk(){
        amountDue = 0.00;
        totalSales = 0.00;
        numCustomers = 0;
        storeName = "GVSU Corner Store";
        
        System.out.println("Welcome to " + storeName + "!");
    }
    
    
    /********************************************
     * @return the total sales amount for the day
     *******************************************/
    public double getTotalSales(){
        return totalSales;
    }
    
    
    /********************************************************
     * @return the current amount due by the current customer
     *******************************************************/
    public double getAmountDue(){
        return amountDue;
    }
    
    
    /******************************************
     * @return the number of customers that day
     *****************************************/
     public int getNumCustomers(){
        return numCustomers; 
    }
    
    
    /***************************************************************
     * Displays the store name, number of customers that day, total
     * sales amount for the day, and average sale amount for the day
     **************************************************************/
    public void reportSales(){
        System.out.println("---------------------------------");
        System.out.println(storeName);
        System.out.println("Number of Customers: " + numCustomers);
        System.out.println("Daily Sales: " + money.format(totalSales));
        if (numCustomers == 0){
            System.out.println("Average Sales: $0.00");
        }
        else{
            double avgSale = totalSales / numCustomers;
            System.out.println("Average Sales: " + money.format(avgSale));
        }
        System.out.println("---------------------------------");
    }
    
    
    /***************************************************
     * Updates the amount due
     * If price is 0 or less, displays a scanning error
     * @param price the price of the scanned object
     **************************************************/
    public void scanItem(double price){
        if (price > 0){
            amountDue += price;
            System.out.println("Price: " + money.format(amountDue));
        }
        else{
            System.out.println("Scanning Error: Please try again.");
        }
    }
    
    
    /**********************************************
     * Checks out the customer
     * displays sales tax and then total amount due
     *********************************************/
    public void checkout(){
        double salesTax = amountDue * TAX_RATE;
        amountDue += salesTax;
        
        System.out.println("Sales Tax: " + money.format(salesTax));
        System.out.println("Amount Due: " + money.format(amountDue));
    }
    
    
    /*********************************************
     * Cancels the current sale
     * Sets amount due to 0 and displays a message
     ********************************************/
    public void cancelSession(){
        amountDue = 0.0;
        System.out.println("Sale cancelled");
    }
    
    
    /****************************************************
     * Scans a coupon, only coupons under $2.00 are valid 
     * Deducts the appropriate amount from the amount due
     * @param value the value of the coupon scanned
     ***************************************************/
    public void scanCoupon(double value){
        if (value > 0 && value <= 2.00){
            amountDue -= value;
            if (amountDue < 0){
                amountDue = 0.0;
            }
            System.out.println("Credit: " + money.format(value));
        }
        else{
            System.out.println("Coupon not valid");
        }
    }
    
    
    /*************************************************************
     * Resets the entire kiosk - only valid employees can use this
     * All numerical values set to 0.0 except tax rate
     * @param id the employee ID that must be considered valid
     ************************************************************/
    public void resetKiosk(int id){
        if (id == 4567){
            totalSales = 0.0;
            amountDue = 0.0;
            numCustomers = 0;
            System.out.println("Kiosk reset");
        }
        else{
            System.out.println("ID not valid");
        }
    }
    
    
    /************************************************************************
     * Makes a payment towards amount due if positive amount
     * subtracts from amount due and adds to total sales
     * increases customer count
     * @param pmt the amount the customer is paying towards their amount due
     ***********************************************************************/
    public void makePayment(double pmt){
        System.out.println("Payment: " + money.format(pmt));
        
        if (pmt <= 0){
            System.out.println("Credit card declined");
        }
        else if (pmt == amountDue){
            amountDue = 0;
            totalSales += pmt;
            numCustomers++;
            System.out.println("Thank You. Have a nice day!");
            System.out.println();
            System.out.println("------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Welcome to " + storeName + "!");
        }
        else if (pmt > amountDue){
            double change = pmt - amountDue;
            totalSales += amountDue;
            amountDue = 0;
            System.out.println("Thank You. Your change is " + money.format(change));
            numCustomers++;
            System.out.println();
            System.out.println("------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("Welcome to " + storeName + "!");
        }
        else{
            amountDue -= pmt;
            totalSales += pmt;
            numCustomers++;
            System.out.println("Remaining Amount Due: " + money.format(amountDue));
        }
    }
    
    
    /********************************************************************
     * Simulates a customer scanning multiple items with each successive
     * item costing a set increment more than the previous item
     * @param items the number of items being scanned
     * @param price the price of the first item
     * @param incr the price increase from one tem to the next
     *******************************************************************/
    public void simulateCustomer(int items, double price, double incr){
        for (int item = 1; item <= items; item++){
            scanItem(price);
            price += incr;
        }
        checkout();
        makePayment(amountDue);
    }
    
    
    /*******************************************************************
     * Simulates multiple customers throughout the day
     * Each customer purchases one more item than the previous customer
     * The first item is $3.00 for each customer
     * each subsequent item's price increases by $0.35
     * @param customers number of customers
     * @param items number of items the first customer purchases
     ******************************************************************/
    public void simulateManyCustomers(int customers, int items){
        for (int customer = 1; customer <= customers; customer++){
            simulateCustomer(items - 1 + customer, 3.00, .35);
        }
    }
    
    
    /**************************************************************
     * Calls multiple methods in order to provide a printout
     * showing the various possible messages to show the instructor
     *************************************************************/
    public static void main(){
        SelfPayKiosk first = new SelfPayKiosk();
        SelfPayKiosk second = new SelfPayKiosk("My Store");
        
        first.reportSales();
        second.scanItem(5.5);
        second.scanItem(-5);
        second.scanCoupon(1.3);
        second.scanCoupon(3);
        second.checkout();
        second.makePayment(-5);
        second.makePayment(10);
        second.reportSales();
        second.resetKiosk(1234);
        second.resetKiosk(4567);
        second.reportSales();
    }
}