import java.util.*;
/**
 * Write a description of class MadLib here.
 *
 * @author (Nick Layman)
 * @version (9/5/2018)
 */

public class MadLib{
    public static void main(){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Adjective:");
        String adjOne = scan.nextLine();
        System.out.print("Adjective:");
        String adjTwo = scan.nextLine();
        System.out.print("Type of bird:");
        String birdType = scan.nextLine();
        System.out.print("Room in a house:");
        String houseRoom = scan.nextLine();
        System.out.print("verb (past tense):");
        String verbOne = scan.nextLine();
        System.out.print("Verb:");
        String verbTwo = scan.nextLine();
        System.out.print("Relative's name:");
        String relativeName = scan.nextLine();
        System.out.print("Noun:");
        String nounOne = scan.nextLine();
        System.out.print("A liquid:");
        String liquidName = scan.nextLine();
        System.out.print("Verb ending in -ing:");
        String verbThree = scan.nextLine();
        System.out.print("Part of the body (plural):");
        String bodyPart = scan.nextLine();
        System.out.print("Plural noun:");
        String nounTwo = scan.nextLine();
        System.out.print("verb ending in -ing:");
        String verbFour = scan.nextLine();
        System.out.print("Noun:");
        String nounThree = scan.nextLine();
        
        System.out.println("It was a " + adjOne + ", cold November day.");
        System.out.println("I woke up to the " + adjTwo + " smell of " + birdType + " roasting in the " + houseRoom + " downstairs.");
        System.out.println("I " + verbOne + " down the stairs to see if I could help " + verbTwo + " the dinner.");
        System.out.println("My mom said, \"See if " + relativeName + " needs a fresh " + nounOne + ".\"");
        System.out.println("So I carried a tray of glasses full of " + liquidName + " into the " + verbThree + " room.");
        System.out.println("When I got there, I couldn't believe my " + bodyPart + "!");
        System.out.println("There were " + nounTwo + " " + verbFour + " on the " + nounThree + "!");
    }
}
