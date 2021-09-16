/**************************************************
 * Driver class to test Dog class
 * @author Ana Posada
 * @version Summer 2013
 * ************************************************
 */

public class PetDriver  { 
    public static void main(String args[])     {
        // creating instances of the Dog Class    
        Dog dog1 = new Dog (45,"Scooby Doo");
        Dog dog2 = new Dog (6,"Bo");
        Dog dog3 = new Dog (2,"Sunny");
        Dog dog4 = new Dog (74,"Lassie");

        System.out.println ("Before invoking the mystery method");
        System.out.println ("==================================");        
        System.out.println ("Dog 1: " + dog1);
        System.out.println ("Dog 2: " + dog2);
        System.out.println ("Dog 3: " + dog3);
        System.out.println ("Dog 4: " + dog4);    

        if (dog1.equals(dog2))
            System.out.println ("\n****dogs 1 and 2 are the same");
        else
            System.out.println ("\n****dogs 1 and 2 are NOT the same");

        // invoking the mystery method
        dog1.mystery(dog2);

        System.out.println ("\nAfter invoking the mystery method");
        System.out.println ("==================================");
        System.out.println ("Dog 1: " + dog1);
        System.out.println ("Dog 2: " + dog2);
        System.out.println ("Dog 3: " + dog3);
        System.out.println ("Dog 4: " + dog4);

        if (dog1.equals(dog2))
            System.out.println ("\n****dogs 1 and 2 are the same");
        else
            System.out.println ("\n****dogs 1 and 2 are NOT  the same");
    }
}
