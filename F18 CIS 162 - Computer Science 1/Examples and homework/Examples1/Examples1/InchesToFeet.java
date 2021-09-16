import java.util.Scanner;
/**
 * Demostrates integer division and mod/remainder operation
 * Converts the total numbers of inches to feet and inches.
 * 
 * @author Ana Posada
 * @version 0.0
 */
public class InchesToFeet {

    public static void main (String[] args)    {
        Scanner sc = new Scanner (System.in);

        // to be entered by user
        int numInches; 

        // to be calculated 
        int feet ;
        int inches;

        // declaring a constant.  Notice the use of UpperCase for the variable name
        final int INCHES_PER_FOOT = 12;

        System.out.print ("Enter number of inches: ");
        numInches = sc.nextInt();

        feet =  numInches / INCHES_PER_FOOT ;

        inches = numInches % INCHES_PER_FOOT;

        System.out.println ("Total number of " + numInches + " inches is the equivalent of " +
            feet + " foot(feet) and " + inches + " inch(es)");
    }
}

