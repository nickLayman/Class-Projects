import java.util.Scanner;
import java.util.Random;

/**
 * Write a description of class RandomRanges here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class RandomRanges{
    public static void main(){
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int low;
        int high;
        int rand1;
        int rand2;
        int rand3;
        
        System.out.println("Enter low: ");
        low = scan.nextInt();
        System.out.println("Enter high: ");
        high = scan.nextInt();
        
        rand1 = rand.nextInt(high - low + 1) + low;
        rand2 = rand.nextInt(high - low + 1) + low;
        rand3 = rand.nextInt(high - low + 1) + low;
        
        System.out.println("Random values: " + rand1 + " " + rand2 + " " + rand3);
    }
}
