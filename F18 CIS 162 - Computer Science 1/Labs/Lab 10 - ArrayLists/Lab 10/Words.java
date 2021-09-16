import java.util.*;
import javax.swing.*;
/**
 * Write a description of class Words here.
 *
 * @author Nick Layman
 * @version 10/30/2018
 */
public class Words{
    private ArrayList<String> info;
    
    public Words(){
        info = new ArrayList<String>();
    }
    
    public void addWord(String str){
        info.add(str);
    }
    
    public void addWords(int num){
        for (int i = 0; i < num; i++){
            String str = JOptionPane.showInputDialog("Enter a word: ");
            addWord(str);
        }
    }
    
    public void display(){
        System.out.println(info);
    }
    
    public boolean removeWord(int index){
        if (index < info.size()){
            info.remove(index);
            return true;
        }
        else
            return false;
    }
    
    public int search(String str){
        for (int i = 0; i < info.size(); i++){
            if (info.get(i).equalsIgnoreCase(str))
                return i;
        }
        return -1;
    }
    
    public void removeEveryOther(){
        for (int i = 0; i < info.size(); i++){
            info.remove(i);
        }
    }
}
