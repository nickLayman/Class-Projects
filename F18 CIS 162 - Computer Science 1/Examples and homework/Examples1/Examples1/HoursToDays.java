import java.util.Scanner;
/**
 * Demostrates integer division and mod/remainder operation
 * Converts the total numbers of hours to days and hours.
 * 
 * @author Ana Posada
 * @version 0.0
 */
public class HoursToDays {

    public static void main (String[] args)     {
        Scanner sc = new Scanner (System.in);

        // to be entered by user
        int numHours; 

        // to be calculated 
        int days = 0;
        int hours = 0;

        final int HOURS_PER_DAY = 24;

        System.out.print ("Enter number of hours: ");
        numHours = sc.nextInt();

        days = numHours / HOURS_PER_DAY ;

        hours = numHours % HOURS_PER_DAY ;

        System.out.println ("Total number of " + numHours + " hours is the equivalent of " +
            days + " day(s) and " + hours + " hour(s)");

    }
}

