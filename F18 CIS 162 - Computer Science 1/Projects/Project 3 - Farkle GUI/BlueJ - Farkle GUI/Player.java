/*****************************************************
 * Simulates a player to be used in Farkle game class
 *
 * @author Nick Layman
 * @version 11/5/2018
 *****************************************************/

public class Player{
    /** name of the player */
    private String name;
    
    /** the player's current official, irreducible score */
    private int score;
    
    /** the player's current subtotal, subject to loss */
    private int subtotal;
    
    /** number of turns the player has taken */
    private int turns;
    
    
    /**********************************************
     * Constructor creates new player given a name
     * Initially has no score, subtotal, or turns
     * @param the new player's name
     *********************************************/
    public Player (String pName){
        name = pName;
        score = 0;
        subtotal = 0;
        turns = 0;
    }
    
    
    /****************************** 
     * gets the name of the player
     * @return player name
     *****************************/
    public String getName(){
        return name;
    }
    
    
    /************************************
     * sets the name of the player
     * @param the new name of the player
     ***********************************/
    public void setName(String n){
        name = n;
    }
    
    
    /**********************************
     * gets the score of the player
     * @return the player's score
     *********************************/
    public int getScore(){
        return score;
    }
    
    
    /*********************************
     * sets the score of the player
     * @param the player's new score
     ********************************/
    public void setScore(int s){
        score = s;
    }
    
    
    /*****************************************
     * gets the subtotal of the player
     * @return the player's current subtotal
     ****************************************/
    public int getSubtotal(){
        return subtotal;
    }
    
    
    /***********************************
     * sets the subtotal of the player
     * @param the player's new subtotal
     **********************************/
    public void setSubtotal(int s){
        subtotal = s;
    }
    
    
    /************************************************
     * gets the number of turns the player has taken
     * @return the player's turns so far
     ************************************************/
    public int getTurns(){
        return turns;
    }
    
    
    /************************************************
     * sets the number of turns the player has taken
     * @param the players new turn count
     ************************************************/
    public void setTurns(int t){
        turns = t;
    }
    
    
    /********************************************************
     * adds the score from the dice to the player's subtotal
     * @param amount to increase the subtotal by
     *******************************************************/
    public void addToSubtotal(int amt){
        subtotal += amt;
    }
    
    
    /********************************************
     * adds the player's subtotal to their score
     ********************************************/
    public void updateScore(){
        score += subtotal;
        subtotal = 0;
        turns++;
    }
    
    
    /********************************************
     * starts a new game for the player
     * resets all player numeric values to zero
     *******************************************/
    public void newGame(){
        score = 0;
        subtotal = 0;
        turns = 0;
    }
}
