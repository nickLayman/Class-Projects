import java.text.NumberFormat;
import javax.swing.JOptionPane;
/*****************************************************
 * BankAccount - Represents a customer’s bank account.  
 * 
 * @author Ana Posada
 * @version Sep 2016
 *******************************************************/
public class BankAccount {
    /** name of the account */
    private String name;

    /** balance of the account */
    private double balance;

    /** account id */
    private int accountID;

    /** annual interest rate */
    private static final double INTEREST = 2.0 / 100.0;

    /***************************************************
     * Default Constructor
     ***************************************************/
    public BankAccount()  {
        name = "Default";
        balance = 0.0;
        accountID = 0;
    }

    /***************************************************
     * Constructor with parameters for each instance variable
     * @param String - name of the account
     * @param double  - initial balance
     * @param int  - account id
     ***********************************************************/
    public BankAccount(String pName, double pBalance, int pAccountID)  {
        name = pName;
        setBalance (pBalance);  // invoking the set method 
        accountID = pAccountID;
    }

    /***************************************************************
     * returns the account ID
     * @return int account ID
     ****************************************************************/
    public int getAccountID () {
        return accountID;
    }

    /***************************************************************
     * returns the account name
     * @return  String account name
     ****************************************************************/
    public String getName () {
        return name;
    }

    /***************************************************************
     * returns the account balance
     * @return  double balance
     ****************************************************************/
    public double getBalance() {
        return balance;
    }

    /***************************************************************
     * simulates a deposit (balance is incremented by amount)
     * @param  double - amount to deposit
     ****************************************************************/
    public void deposit (double amount) {
        // checks for user errors - amount must be positive
        if (amount > 0.0)
            balance = balance + amount;
        else
            JOptionPane.showMessageDialog(null, "Error ---- amount must be positive");
    }

    /***************************************************************
     * simulates a withdraw (subtracts the amount from balance)
     * @param  double - amount to withdraw
     ****************************************************************/
    public void withdraw (double amount) {
        // checks for user errors - amount must be positive and 
        // the account must have enough  money to withdraw
        if (amount > 0.0 && amount <= balance)
            balance = balance - amount;
        else
            JOptionPane.showMessageDialog(null, "Error ---- amount must be positive" +
                "\n or you don't have sufficient funds"); 
    }

    /***************************************************************
     * changes the name to the String passed as parameter
     * @param  String - account new name
     ****************************************************************/
    public void setName (String pName) {
        name = pName;
    }

    /***************************************************************
     * sets the account id to the value passed as parameter
     * @param  int - account id
     ****************************************************************/
    public void setAccountID (int pAccountID) {
        accountID = pAccountID;
    }

    /***************************************************************
     * sets the balance to the value entered as input parameter
     * @param  double- new value for balance
     ****************************************************************/
    public void setBalance (double pBalance) {
        // checking user errors - pBalance must be a positive number
        if (pBalance > 0.0)
            balance = pBalance;
        else
            JOptionPane.showMessageDialog(null, "Balance must be positive");
    }

    /***************************************************************
     * prints the monthly statement 
     * \n - means new line
     * \t - means tab
     ****************************************************************/
    public void monthlyStatement() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        System.out.println ("\nMonthly Statement");
        System.out.println ("=================");
        System.out.println ("Account ID:\t\t" + accountID + 
            "\nName:\t\t\t" + name + 
            "\nInitial Balance:\t" + fmt.format (balance) +  
            "\nAnnual Interest Rate:\t" + INTEREST +       
                // ======= notice that the method calcInterestPaid() is invoked below
            "\nInterest paid:\t\t" + fmt.format(calcInterestPaid()) + 
            "\nEnd Balance:\t\t" + fmt.format(balance + calcInterestPaid()));
    }

    /***************************************************************
     * calculates the interest paid during one month
     * @return double - interest paid on the account during one month.
     ****************************************************************/
    // Notice that this method is private.  The outside class won't be
    // able to access this method.
    private double calcInterestPaid() {
        return balance * INTEREST / 12;
    }

    /***************************************************************
     * converts the object of the class BankAccount to a String
     * @return  String 
     ****************************************************************/
     // notice that this method is invoked automatically when you 
     // print a complete object 
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return "\nName: " + name + "\nBalance: " + fmt.format (balance) +  
        "\nAnnual Interest Rate: " + INTEREST + "\nAccount ID: " + accountID;
    }
}
