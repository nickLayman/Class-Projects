import java.util.*;
/**
 * Write a description of class Dice here.
 *
 * @author Nick Layman
 * @version 10/30/2018
 */
public class Dice{
    private ArrayList<GVdie> allDice;
    
    public Dice(int num){
        allDice =  new ArrayList<GVdie>();
        for (int i = 0; i < num; i++){
            GVdie die = new GVdie();
            allDice.add(die);
        }
    }
    
    public void roll(){
        for (GVdie d : allDice){
            d.roll();
        }
    }
    
    public ArrayList<GVdie> getDice(){
        return allDice;
    }
    
    public int getTotal(){
        int sum = 0;
        
        for (GVdie d : allDice){
            sum += d.getValue();
        }
        
        return sum;
    }
    
    public int getCount(int val){
        if (val > 6 || val < 1){
            return -1;
        }
        
        int count = 0;
        for (GVdie d : allDice){
            if (d.getValue() == val)
                count++;
        }
        
        return count;
    }
}
