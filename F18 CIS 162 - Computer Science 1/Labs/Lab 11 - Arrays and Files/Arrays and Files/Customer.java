/**
 * Maintains information about a customer
 * first name, last name, and email
 *
 * @author Nick Layman
 * @version 11/6/2018
 */
public class Customer{
    private String firstName;
    private String lastName;
    private String email;
    
    public Customer(String pFirst, String pLast, String pEmail){
        firstName = pFirst;
        lastName = pLast;
        email = pEmail;
    }
    
    public String getFirst(){
        return firstName;
    }
    
    public void setFirst(String pFirst){
        firstName = pFirst;
    }
    
    public String getLast(){
        return lastName;
    }
    
    public void setLast(String pLast){
        lastName = pLast;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String pEmail){
        email = pEmail;
    }
    
    public String toString(){
        return firstName + " " + lastName + ": " + email;
    }
}
