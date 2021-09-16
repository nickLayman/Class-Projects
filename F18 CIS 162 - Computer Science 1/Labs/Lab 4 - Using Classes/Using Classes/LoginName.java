import java.util.Scanner;

/**
 * Write a description of class LoginName here.
 *
 * @author (Nick Layman)
 * @version (9/18/2018)
 */
public class LoginName{
    public static void main(){
        int fourDigits;
        String firstName;
        String lastName;
        String login;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter first name: ");
        firstName = scan.next();
        System.out.println("Enter last name: ");
        lastName = scan.next();
        System.out.println("Enter 4-digits: ");
        fourDigits = scan.nextInt();
        
        login = lastName.substring(0,5) + firstName.substring(0,1) + (fourDigits % 100);
        
        System.out.println("Your login name: " + login);
    }
}
