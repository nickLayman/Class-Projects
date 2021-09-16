import java.text.*;
import java.util.Scanner;

/**
 * Write a description of class Cylinders here.
 *
 * @author (Nick Layman)
 * @version (9/18/2018)
 */

public class Cylinders{
   public static void main(){
       Scanner scan = new Scanner(System.in);
       DecimalFormat df = new DecimalFormat ("0.0");
       double radius;
       double height;
       double volume;
       double area;
       
       System.out.print("Radius: ");
       radius = scan.nextDouble();
       System.out.print("Height: ");
       height = scan.nextDouble();
       
       volume = Math.PI * Math.pow(radius, 2) * height;
       area = 2 * Math.PI * radius * height;
       
       System.out.println("Volume = " + df.format(volume) + "cubic inches.");
       System.out.println("Area = " + df.format(area) + "square inches.");
   }
}
