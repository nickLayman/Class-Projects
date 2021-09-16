/**
 * Testing the Farkle game class
 *
 * @author Nick Layman
 * @version 11/13/2018
 */
public class FarkleTest{
    public static void main(String[] args){
        Farkle game = new Farkle();

        System.out.println("\nTesting begins...");
        
        
        /*********************************** test straights **************************************************/
        game.passDice();
        game.setAllDice(new int[] {1,2,3,4,5,6});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1000)
            System.out.println("FAIL: Straight not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {5,2,4,1,6,3});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1000)
            System.out.println("FAIL: Straight not scored correctly");
            
        
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {6,5,4,3,2,1});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1000)
            System.out.println("FAIL: Straight not scored correctly");
            
        
        /*********************************** test three pairs **************************************************/
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {1,1,2,2,3,3});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1000)
            System.out.println("FAIL: Three Pairs not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {1,2,3,1,2,3});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1000)
            System.out.println("FAIL: Three Pairs not scored correctly");
            
        
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {3,1,3,2,1,2});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1000)
            System.out.println("FAIL: Three Pairs not scored correctly");
            
            
        /*********************************** test ones **************************************************/
        for (Player p : game.players)
            p.setScore(0);
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {1,2,3,4,6,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 100)
            System.out.println("FAIL: Ones not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {1,2,1,4,6,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 200)
            System.out.println("FAIL: Ones not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {1,2,3,4,6,1});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 200)
            System.out.println("FAIL: Ones not scored correctly");
            
            
        /*********************************** test fives **************************************************/
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {5,4,3,6,4,2});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 50)
            System.out.println("FAIL: Fives not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {5,4,3,5,4,2});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 100)
            System.out.println("FAIL: Fives not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {3,4,5,6,4,5});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 100)
            System.out.println("FAIL: Fives not scored correctly");
            
            
        /*********************************** test ones: 3, 4, 5, 6 of a kind **************************************************/
        for (Player p : game.players)
            p.setScore(0);
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {1,1,1,2,3,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1000)
            System.out.println("FAIL: Three Ones not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {1,2,1,3,4,1});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1000)
            System.out.println("FAIL: Three Ones not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {1,2,3,1,1,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1000)
            System.out.println("FAIL: Three Ones not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {1,1,1,1,3,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 2000)
            System.out.println("FAIL: Four Ones not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {1,1,3,4,1,1});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 2000)
            System.out.println("FAIL: Four Ones not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {1,3,1,1,4,1});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 2000)
            System.out.println("FAIL: Four Ones not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {1,1,1,1,1,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 3000)
            System.out.println("FAIL: Five Ones not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {1,1,1,3,1,1});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 3000)
            System.out.println("FAIL: Five Ones not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {2,1,1,1,1,1});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 3000)
            System.out.println("FAIL: Five Ones not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {1,1,1,1,1,1});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 4000)
            System.out.println("FAIL: Six Ones not scored correctly");
            
        
        /*********************************** test twos: 3, 4, 5, 6 of a kind **************************************************/
        for (Player p : game.players)
            p.setScore(0);
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {2,2,2,3,3,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 200)
            System.out.println("FAIL: Three Twos not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {2,2,3,3,4,2});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 200)
            System.out.println("FAIL: Three Twos not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {3,2,3,2,2,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 200)
            System.out.println("FAIL: Three Twos not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {2,2,2,2,3,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 400)
            System.out.println("FAIL: Four Twos not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {2,2,3,4,2,2});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 400)
            System.out.println("FAIL: Four Twos not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {2,3,2,2,4,2});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 400)
            System.out.println("FAIL: Four Twos not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {2,2,2,2,2,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 600)
            System.out.println("FAIL: Five Twos not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {2,2,2,3,2,2});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 600)
            System.out.println("FAIL: Five Twos not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {3,2,2,2,2,2});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 600)
            System.out.println("FAIL: Five Twos not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {2,2,2,2,2,2});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 800)
            System.out.println("FAIL: Six Twos not scored correctly");
            
            
        /*********************************** test threes: 3, 4, 5, 6 of a kind **************************************************/
        for (Player p : game.players)
            p.setScore(0);
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {3,3,3,2,2,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 300)
            System.out.println("FAIL: Three Threes not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {3,3,2,3,4,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 300)
            System.out.println("FAIL: Three Threes not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {2,3,3,3,2,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 300)
            System.out.println("FAIL: Three Threes not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {3,3,3,3,2,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 600)
            System.out.println("FAIL: Four Threes not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {3,3,2,4,3,3});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 600)
            System.out.println("FAIL: Four Threes not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {2,3,3,3,4,3});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 600)
            System.out.println("FAIL: Four Threes not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {3,3,3,3,3,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 900)
            System.out.println("FAIL: Five Threes not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {3,3,3,2,3,3});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 900)
            System.out.println("FAIL: Five Threes not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {2,3,3,3,3,3});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 900)
            System.out.println("FAIL: Five Threes not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {3,3,3,3,3,3});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1200)
            System.out.println("FAIL: Six Threes not scored correctly");
            
            
        /*********************************** test fours: 3, 4, 5, 6 of a kind **************************************************/
        for (Player p : game.players)
            p.setScore(0);
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {4,4,3,2,2,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 400)
            System.out.println("FAIL: Three Fours not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {4,4,2,3,3,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 400)
            System.out.println("FAIL: Three Fours not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {2,3,4,4,2,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 400)
            System.out.println("FAIL: Three Fours not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {4,4,4,4,2,3});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 800)
            System.out.println("FAIL: Four Fours not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {4,4,2,3,4,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 800)
            System.out.println("FAIL: Four Fours not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {2,4,4,3,4,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 800)
            System.out.println("FAIL: Four Fours not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {4,4,4,4,4,3});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1200)
            System.out.println("FAIL: Five Fours not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {4,4,4,2,4,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1200)
            System.out.println("FAIL: Five Fours not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {2,4,4,4,4,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1200)
            System.out.println("FAIL: Five Fours not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {4,4,4,4,4,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1600)
            System.out.println("FAIL: Six Fours not scored correctly");
            
            
        /*********************************** test fives: 3, 4, 5, 6 of a kind **************************************************/
        for (Player p : game.players)
            p.setScore(0);
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {5,5,3,2,2,5});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 500)
            System.out.println("FAIL: Three Fives not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {5,5,2,3,3,5});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 500)
            System.out.println("FAIL: Three Fives not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {2,3,5,5,2,5});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 500)
            System.out.println("FAIL: Three Fives not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {5,5,5,5,2,3});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1000)
            System.out.println("FAIL: Four Fives not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {5,5,2,3,5,5});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1000)
            System.out.println("FAIL: Four Fives not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {2,5,5,3,5,5});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1000)
            System.out.println("FAIL: Four Fives not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {5,5,5,5,5,3});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1500)
            System.out.println("FAIL: Five Fives not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {5,5,5,2,5,5});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1500)
            System.out.println("FAIL: Five Fives not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {2,5,5,5,5,5});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1500)
            System.out.println("FAIL: Five Fives not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {5,5,5,5,5,5});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 2000)
            System.out.println("FAIL: Six Fives not scored correctly");
            
            
        /*********************************** test sixes: 3, 4, 5, 6 of a kind **************************************************/
        for (Player p : game.players)
            p.setScore(0);
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {6,6,3,2,2,6});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 600)
            System.out.println("FAIL: Three Sixes not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {6,6,2,3,3,6});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 600)
            System.out.println("FAIL: Three Sixes not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {2,3,6,6,2,6});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 600)
            System.out.println("FAIL: Three Sixes not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {6,6,6,6,2,3});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1200)
            System.out.println("FAIL: Four Sixes not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {6,6,2,3,6,6});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1200)
            System.out.println("FAIL: Four Sixes not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {2,6,6,3,6,6});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1200)
            System.out.println("FAIL: Four Sixes not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {6,6,6,6,6,3});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1800)
            System.out.println("FAIL: Five Sixes not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {6,6,6,2,6,6});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1800)
            System.out.println("FAIL: Five Sixes not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {2,6,6,6,6,6});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1800)
            System.out.println("FAIL: Five Sixes not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {6,6,6,6,6,6});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 2400)
            System.out.println("FAIL: Six Sixes not scored correctly");
            
            
        /*********************************** mixed tests **************************************************/
        for (Player p : game.players)
            p.setScore(0);
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {1,3,2,5,3,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 150)
            System.out.println("FAIL: Ones or Fives not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {1,5,1,5,3,4});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 300)
            System.out.println("FAIL: Ones or Fives not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {1,5,1,5,1,5});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1500)
            System.out.println("FAIL: 3ofAKind 1 or 5 not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {2,2,2,5,5,5});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 700)
            System.out.println("FAIL: 3ofAKind 2 or 5 not scored correctly");
            
        
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {1,6,1,6,6,1});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1600)
            System.out.println("FAIL: 3ofAKind 1 or 6 not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {6,6,6,5,5,5});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 1100)
            System.out.println("FAIL: 3ofAKind 5 or 6 not scored correctly");
            
           
        for (Player p : game.players)
            p.setScore(0);
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {1,1,1,1,4,5});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 2050)
            System.out.println("FAIL: 4ofAKind 1 or Fives not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(2);
        game.setAllDice(new int[] {2,2,2,2,3,5});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 450)
            System.out.println("FAIL: 4ofAKind 2 or Fives not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(3);
        game.setAllDice(new int[] {4,4,4,4,1,5});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 950)
            System.out.println("FAIL: 4ofAKind 4 or Ones or Fives not scored correctly");
            
            
        for (Player p : game.players)
            p.setScore(0);
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {1,1,1,1,1,5});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 3050)
            System.out.println("FAIL: 5ofAKind 1 or Fives not scored correctly");
            
            
        game.passDice();
        game.setActivePlayer(1);
        game.setAllDice(new int[] {2,2,2,2,2,1});
        for (int i = 1; i <= 6; i++)
            game.selectDie(i);
        game.scoreSelectedDice();
        if (game.getActivePlayer().getSubtotal() != 700)
            System.out.println("FAIL: 5ofAKind 2 or Ones not scored correctly");
            
            
        System.out.println("Testing Done.");
    }
}
