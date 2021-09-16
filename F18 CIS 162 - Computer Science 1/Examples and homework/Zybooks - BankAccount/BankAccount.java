
/**
 * Write a description of class BankAccount here.
 *
 * @author (Nick Layman)
 * @version (9/29/2018)
 */
public class BankAccount{
    String name;
    double savings;
    double checking;
    
    public BankAccount(String n, int amt){
        name = n;
        checking = amt;
        savings = 1000.0;
    }
    
    public void setName(String n){
        name = n;
    }
    
    public String getName(){
        return name;
    }
    
    public void setChecking(double amt){
        checking = amt;
    }
    
    public double getChecking(){
        return checking;
    }
    
    public void setSavings(double amt){
        savings = amt;
    }
    
    public double getSavings(){
        return savings;
    }
    
    public void depositChecking(double amt){
        if (amt > 0)
            checking += amt;
    }
    
    public void depositSavings(double amt){
        if (amt > 0)
            savings += amt;
    }
    
    public void withdrawChecking(double amt){
        if (amt > 0)
            checking -= amt;
    }
    
    public void withdrawSavings(double amt){
        if (amt > 0)
            savings -= amt;
    }
    
    public void transferToSavings(double amt){
        if (amt > 0){
            checking -= amt;
            savings += amt;
        }
    }

    public static void main(String args[]){

    } 
}