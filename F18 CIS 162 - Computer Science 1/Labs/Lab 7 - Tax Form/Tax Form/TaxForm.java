import java.util.*;
import java.text.*;

/**
 * Calculates U.S. federal income tax given specific information
 *
 * @author Nick Layman
 * @version 10/9/2018
 */

public class TaxForm{
    /** Creates a new scanner called scan */
    Scanner scan = new Scanner(System.in);
    
    /** Creates format object used for when money is printed */
    NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);
        
    /** amount earned and on W-2 */
    double wages;
        
    /** amount a bank paid you in interest */
    double taxableInterest;
        
    /** government payments for unemployment insurance */
    double unemploymentComp;
        
    /** tax withheld from paychecks by employer */
    double fedTaxWithheld;
        
    /** number of people dependent on your income */
    int exemptions;
    
    /** deduction from income based on exemptions */
    double deduction;
    
    /** wages, interest, and unemployment */
    double agi;
    
    /** taxable income - AGI minus deductions */
    double taxableIncome;
    
    /** tax based on taxable income and rates and filing status */
    double tax;
    
    /** amount due if tax is greater than withheld */
    double amtOwed;
    
    /** refund amount if withheld is greater than tax*/
    double refund;
    
    /** ten percent tax rate: income 0 - 9325 */
    final double TEN_PCT = .10;
        
    /** fifteen percent tax rate: income 9325 - 37950 */
    final double FIFTEEN_PCT = .15;
        
    /** twenty five percent tax rate: income 37950 - 91900 */
    final double TWENTY_FIVE_PCT = .25;
        
    /** twenty eight percent tax rate: income 91900+ */
    final double TWENTY_EIGHT_PCT = .28;
    

    /*************************************************************
     * Prompts user for information and displays adjusted gross 
     * income, taxable income, federal tax, refund, and amount due
     ************************************************************/
    public void estimateTaxes(){
        /** lets user know to enter their own information */
        System.out.println("Your Information");
        
        /** gets wage amount from user */
        System.out.print("Wages, salaries and tips: $");
        wages = scan.nextDouble();
        
        /** gets taxable interest from user */
        System.out.print("Taxable interest: $");
        taxableInterest = scan.nextDouble();
        
        /** gets unemploymen compensation from user */
        System.out.print("Unemployment compensation: $");
        unemploymentComp = scan.nextDouble();
        
        /** gets number of exemptions from user */
        System.out.print("Exemptions (0, 1 or 2): ");
        exemptions = scan.nextInt();
        
        /** gets federal income tax withheld from user */
        System.out.print("Federal income tax withheld: $");
        fedTaxWithheld = scan.nextDouble();
        
        
        
        
        /** Calculates Adjusted Gross Income */
        agi = wages + taxableInterest + unemploymentComp;
        
        
        /** Determines deduction based on exemptions */
        switch (exemptions){
            case 0:
                deduction = 6350;
                break;
            case 1:
                deduction = 10400;
                break;
            case 2:
                deduction = 20800;
        }
        
        
        /** Calculates taxable income and keeps it positive */
        taxableIncome = agi - deduction;
        if (taxableIncome < 0)
            taxableIncome = 0;
        
        
        /** Calculates tax for - rounded to nearest whole number */
        /** checks if single */
        if (exemptions != 2){
            if (taxableIncome <= 9325)
                tax = Math.round(taxableIncome * TEN_PCT);
            else if(taxableIncome <= 37950)
                tax = Math.round((taxableIncome - 9325) * FIFTEEN_PCT + 932.5);
            else if(taxableIncome <= 91900)
                tax = Math.round((taxableIncome - 37950) * TWENTY_FIVE_PCT + 5226.25);
            else
                tax = Math.round((taxableIncome - 91900) * TWENTY_EIGHT_PCT + 18713.75);
        }
        
        /** if married filing jointly */
        else{
            if (taxableIncome <= 18650)
                tax = Math.round(taxableIncome * TEN_PCT);
            else if (taxableIncome <= 75900)
                tax = Math.round((taxableIncome - 18650) * FIFTEEN_PCT + 1865);
            else
                tax = Math.round((taxableIncome - 75900) * TWENTY_FIVE_PCT + 10452.5);
        }
        
        
        /** Calculates federal tax owed to or due from the user */
        if (fedTaxWithheld > tax){
            amtOwed = 0;
            refund = fedTaxWithheld - tax;
        }
        else if (tax > fedTaxWithheld){
            refund = 0;
            amtOwed = tax - fedTaxWithheld;
        }
        else{
            refund = 0;
            amtOwed = 0;
        }
        
        
        /** Prints out results using Number Format */
        System.out.println();
        System.out.println("Your Results");
        System.out.println("AGI: " + fmt.format(agi));
        System.out.println("Taxable Income: " + fmt.format(taxableIncome));
        System.out.println("Federal Tax: " + fmt.format(tax));
        if (refund > 0)
            System.out.println("Your Refund: " + fmt.format(refund));
        else
            System.out.println("Amount due: " + fmt.format(amtOwed));
    }
}