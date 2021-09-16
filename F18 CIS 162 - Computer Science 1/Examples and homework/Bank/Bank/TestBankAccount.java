
/****************************************************
 * TestBankAccount - used to test the BankAccount class
 * 
 * @author Ana Posada
 * @version September 2016
 *********************************************************/
public class TestBankAccount {

    public static void main (String [] args) {

        // instantiating objects of the BankAccount class
        // default constructor
        BankAccount ac1 = new BankAccount();

        // second constructor
        BankAccount ac2 = new BankAccount("Christian L.", 456.9, 2);
        BankAccount ac3 = new BankAccount("Brittany R.", 100.0, 3);
        BankAccount ac4 = new BankAccount("Niba N.", 100.0, 4);

        // invoking several methods of the BankAccount class for ac2
        System.out.println ("Account 2 Name: " + ac2.getName());
        System.out.println ("Account 2 Balance: " + ac2.getBalance());
        ac2.deposit (50.0);
        System.out.println ("Account 2 Balance after deposit: " + ac2.getBalance());

        // invoking mutator methods for account 1
        ac1.setName ("Margaret K.");
        ac1.setAccountID (1);
        ac1.deposit (500.99);

        // printing the four objects - the toString method of BankAccount 
        // will be invoked automatically
        System.out.println ("printing the four objects ");
        System.out.println (ac1);
        System.out.println (ac2);
        System.out.println (ac3);
        System.out.println (ac4);

        // Testing user errors (negative numbers as parameters, etc.)
        System.out.println ("Testing user errors");

        ac2.deposit (-50.0);
        ac2.withdraw (-80);
        ac2.withdraw(1500.00);
        
        // invoking monthly statement for ac2
        ac2.monthlyStatement();
    }
}
