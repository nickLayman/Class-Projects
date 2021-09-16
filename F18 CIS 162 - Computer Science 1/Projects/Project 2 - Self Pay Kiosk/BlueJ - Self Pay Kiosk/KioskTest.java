
/**
 * Tests the SelfPayKiosk class
 *
 * @author Nick Layman
 * @version 10/3/2018
 */
public class KioskTest{
    public static void main(String args[]){
        int errors = 0;
        
        SelfPayKiosk kiosk1 = new SelfPayKiosk();
        SelfPayKiosk kiosk2 = new SelfPayKiosk("Nickel and Dime");
        
        // scan first item - check amount due
        kiosk1.scanItem(5.0);
        if(Math.abs(kiosk1.getAmountDue() - 5.0) >= .01){
            errors++;
            System.out.println("    ERROR: amount due should be 5.00");
        }
        
        // scan second item - check that amount due was added
        kiosk1.scanItem(10.01);
        if(Math.abs(kiosk1.getAmountDue() - 15.01) >= .01){
            errors++;
            System.out.println("    ERROR: amount due should be 15.00");
        }
        
        // Check for scanning error
        kiosk1.scanItem(0);
        if(Math.abs(kiosk1.getAmountDue() - 15.01) >= .01){
            errors++;
            System.out.println("    ERROR: amount due should be 15.01");
        }
        
        // not mixing 2 kiosks
        kiosk2.scanItem(5.0);
        if(Math.abs(kiosk2.getAmountDue() - 5.0) >= .01){
            errors++;
            System.out.println("    ERROR: amount due should be 5.00");
        }
        
        // sales tax check
        kiosk1.checkout();
        if(Math.abs(kiosk1.getAmountDue() - 15.91) >= .01){
            errors++;
            System.out.println("    ERROR: amount due should be 15.91");
        }
        
        // paying negative amounts
        kiosk1.makePayment(-5.0);
        if(Math.abs(kiosk1.getAmountDue() - 15.91) >= .01){
            errors++;
            System.out.println("    ERROR: amount due should be 15.91");
        }
        
        // paying partial amount
        kiosk1.makePayment(5);
        if(Math.abs(kiosk1.getAmountDue() - 10.91) >= .01){
            errors++;
            System.out.println("    ERROR: amount due should be 10.91");
        }
        
        //paying too much
        kiosk1.makePayment(100);
        if(Math.abs(kiosk1.getAmountDue() - 0) >= .01){
            errors++;
            System.out.println("    ERROR: amount due should be 0.00");
        }
        
        //paying with exact change
        kiosk2.makePayment(5.0);
        if(Math.abs(kiosk2.getAmountDue() - 0) >= .01){
            errors++;
            System.out.println("    ERROR: amount due should be 0.00");
        }
        
        //simulating customer
        kiosk1.resetKiosk(4567);
        kiosk1.simulateCustomer(10, 1, .1);
        if(Math.abs(kiosk1.getTotalSales() - 15.37) >= .01){
            errors++;
            System.out.println("    ERROR: total sales should be 15.37");
            System.out.println("    Got total sales: " + kiosk1.getTotalSales());
        }
        
        //test coupon - negative amount
        kiosk1.scanItem(14.5);
        kiosk1.scanCoupon(-1.5);
        if(Math.abs(kiosk1.getAmountDue() - 14.5) >= .01){
            errors++;
            System.out.println("    ERROR: amount due should still be 14.5");
        }
        
        //test coupon - valid amount
        kiosk1.scanCoupon(1.5);
        if(Math.abs(kiosk1.getAmountDue() - 13) >= .01){
            errors++;
            System.out.println("    ERROR: amount due should be 13");
        }
        
        //test coupon - too high of a discount
        kiosk1.scanCoupon(5);
        if(Math.abs(kiosk1.getAmountDue() - 13) >= .01){
            errors++;
            System.out.println("    ERROR: amount due should still be 13");
        }
        
        //test coupon - 0, worthless
        kiosk1.scanCoupon(0);
        if(Math.abs(kiosk1.getAmountDue() - 13) >= .01){
            errors++;
            System.out.println("    ERROR: amount due should STILL be 13");
        }
        
        
        //attempt reset kiosk - wrong code
        kiosk1.resetKiosk(1234);
        if(Math.abs(kiosk1.getAmountDue() - 13) >= .01){
            errors++;
            System.out.println("    ERROR: amount due should STILLL be 13");
        }
        
        //reset kiosk - correct code
        kiosk1.resetKiosk(4567);
        if(Math.abs(kiosk1.getAmountDue() - 0) >= .01){
            errors++;
            System.out.println("    ERROR: amount due should be 0.00");
        }
        if(Math.abs(kiosk1.getTotalSales() - 0) >= .01){
            errors++;
            System.out.println("    ERROR: total sales should be 0");
        }
        if(kiosk1.getNumCustomers() != 0){
            errors++;
            System.out.println("    ERROR: number of customers should be 0");
        }
        
        //cancel a session
        kiosk1.scanItem(5);
        kiosk1.cancelSession();
        if(Math.abs(kiosk1.getAmountDue() - 0) >= .01){
            errors++;
            System.out.println("    ERROR: amount due should be 0");
        }
        
        //simulate many customers
        kiosk1.simulateManyCustomers(10,5);
        if(Math.abs(kiosk1.getTotalSales() - 467.2) >= .01){
            errors++;
            System.out.println("    ERROR: total sales should be 467.2");
        }
        
        
        //print number of errors
        System.out.println("total errors: " + errors);
    }
}