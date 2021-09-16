import java.text.*;
import java.util.Scanner;

/**
 * Write a description of class TriangleArea here.
 *
 * @author (Nick Layman)
 * @version (9/18/2018)
 */

public class TriangleArea{
    public static void main(){
        DecimalFormat df = new DecimalFormat("0.000");
        Scanner scan = new Scanner(System.in);
        double sideA;
        double sideB;
        double sideC;
        double semiperimeter;
        double area;
        
        System.out.println("Enter Side A: ");
        sideA = scan.nextDouble();
        System.out.println("Enter Side B: ");
        sideB = scan.nextDouble();
        System.out.println("Enter Side C: ");
        sideC = scan.nextDouble();
        
        semiperimeter = (sideA + sideB + sideC) / 2;
        area = Math.sqrt(semiperimeter * (semiperimeter - sideA) * 
            (semiperimeter - sideB) * (semiperimeter - sideC));
            
        System.out.println("The area of the triangle is: " + df.format(area));
    }
}
