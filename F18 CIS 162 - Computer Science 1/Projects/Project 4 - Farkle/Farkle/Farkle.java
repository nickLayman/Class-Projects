import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/********************************************************************************************************************************
 * Farkle game rules, scores, and background stuff
 *
 * @author Nick Layman
 * @version 11/22/2018
 *******************************************************************************************************************************/
public class Farkle{
    /** the current player, changes throughout game */ 
    private Player currentPlayer;

    /** the best player, info read from .txt file later */
    private Player bestPlayer;

    /** an array of all of the players */
    public Player[] players;
    
    /** the number of players playing */
    private final int NUM_PLAYERS = 3;

    /** the dice array, taken from GVdie class */
    private GVdie[] theDice;

    /** the number of dice used in the game */
    private final int NUM_DICE = 6;

    /*******************************************************
     * an array of how many of each value of dice there are
     * [# of ones, # of twos, ... , # of sixes] 
     ******************************************************/
    private int[] tally;

    /** whether it is okay to roll the dice */
    private boolean okToRoll;

    /** whether it is okay to pass the dice */
    private boolean okToPass;

    /** whether this is the first roll of this player's turn */
    private boolean initialRoll;

    /** score value if a straight is rolled */
    private final int STRAIGHT = 1000;

    /** score value if three separate pairs are rolled */
    private final int THREE_PAIRS = 1000;

    /** an array of score values depending on how many of each die are rolled */
    private final int[][] ofAKind =
           {{100, 200, 1000, 2000, 3000, 4000},
            {0,   0,   200,  400,  600,  800},
            {0,   0,   300,  600,  900,  1200},   // [dice value - 1][# of a kind - 1]
            {0,   0,   400,  800,  1200, 1600},
            {50,  100, 500,  1000, 1500, 2000},
            {0,   0,   600,  1200, 1800, 2400}};

    /** score needed to win the game */
    private final int WINNING_SCORE = 10000;

    /***************************************************************************************************************************
     * constructor
     * instantiates dice, tally, players, and best player
     * and sets all values to 0
     **************************************************************************************************************************/
    public Farkle(){
        theDice = new GVdie[NUM_DICE];
        for (int i = 0; i < NUM_DICE; i++){
            theDice[i] = new GVdie();
        }
        
        tally = new int[NUM_DICE];

        players = new Player[NUM_PLAYERS];
        for (int i = 1; i <= NUM_PLAYERS; i++){
            players[i - 1] = new Player("Player " + i);
        }
        
        currentPlayer = players[0];

        loadBestPlayer();

        resetGame();
    }
    
    
    /*********************************************************************
     * saves the best player's information to bestplayer.txt
     ********************************************************************/
    public void saveBestPlayer(){
        try{
            PrintWriter out = null;
            
            out = new PrintWriter("bestplayer.txt");
            
            out.println(bestPlayer.getName());
            out.println(bestPlayer.getScore());
            out.println(bestPlayer.getTurns());
            
            out.close();
        }
        catch(IOException e){
            System.out.println("Failed to save to the data file: bestplayer.txt");
        }
    }
    
    
    /************************************************************************
     * reads and displays best player info from file bestplayer.txt
     * saves read info from file to bestPlayer
     ***********************************************************************/
    public void loadBestPlayer(){
        try{ 
            // open the text file and use a Scanner to read the text
            FileInputStream fileByteStream = new FileInputStream("bestplayer.txt");
            Scanner scnr = new Scanner(fileByteStream);

            bestPlayer = new Player(scnr.nextLine());
            bestPlayer.setScore(scnr.nextInt());
            bestPlayer.setTurns(scnr.nextInt());

            fileByteStream.close();
        }
        catch(IOException e) {
            System.out.println("Failed to read the data file: bestplayer.txt");
        }
        catch(InputMismatchException e) {
            System.out.println("Failed to read the data file: bestplayer.txt");
        }
    }
    
    
    /***************************************************************************************************************************
     * returns the current player playing
     * @return the current player
     **************************************************************************************************************************/
    public Player getActivePlayer(){
        return currentPlayer;
    }

    
    /***************************************************************************************************************************
     * returns if the current player has won
     * updates best player if the current, winning player did better
     * @return if we have a winner
     **************************************************************************************************************************/
    public boolean gameOver(){
        if (currentPlayer.getScore() >= WINNING_SCORE){
            checkBestScore();
        }
        
        saveBestPlayer();
        
        return currentPlayer.getScore() >= WINNING_SCORE;
    }

    
    /**********************************************************************
     * checks if the current score is better than the best score
     * called at game over
     **********************************************************************/
    private void checkBestScore(){
        if (currentPlayer.getTurns() < bestPlayer.getTurns()){
            setBestPlayer(currentPlayer);
        }
    }
    
    
    /***************************************************************************************************************************
     * gets the dice array 
     * @return the dice array
     **************************************************************************************************************************/
    public GVdie[] getDice(){
        return theDice;
    }

    
    /***************************************************************************************************************************
     * tallies up the number of each dice value
     * [# of ones selected, # of twos selected, ... , # of sixes selected]
     **************************************************************************************************************************/
    private void tallySelectedDice(){
        for (int i = 0; i < tally.length; i++){
            tally[i] = 0;
        }

        for (GVdie d : theDice){
            if(d.isSelected()){
                int val = d.getValue();
                tally[val - 1]++;
            }
        }
    }

    
    /***************************************************************************************************************************
     * tallies up the unscored dice
     * [# of ones unscored, # of twos unscored, ... , # of sixes unscored]
     * used to check if player farkles
     **************************************************************************************************************************/
    private void tallyUnscoredDice(){
        for (int i = 0; i < tally.length; i++){
            tally[i] = 0;
        }

        for (GVdie d : theDice){
            if(!d.isScored()){
                int val = d.getValue();
                tally[val - 1]++;
            }
        }
    }

    
    /***************************************************************************************************************************
     * checks if current roll is a straight
     * checks if there is one of every value
     * @return if current roll is a straight
     **************************************************************************************************************************/
    private boolean hasStraight(){
        for (int i : tally){
            if (i != 1){
                return false;
            }
        }

        return true;
    }

    
    /***************************************************************************************************************************
     * checks if there are three distinct pairs in the current roll
     * @return if there are three pairs
     **************************************************************************************************************************/
    private boolean hasThreePairs(){
        int countPairs = 0;

        for (int i : tally){
            if (i == 2){
                countPairs++;
            }
        }

        return countPairs == 3;
    }

    
    /***************************************************************************************************************************
     * resets the dice and buttons
     * used when dice are passed
     **************************************************************************************************************************/
    private void nextTurn(){
        for (GVdie d : theDice){
            d.setScored(false);
            d.setSelected(false);
            d.setBlank();
        }

        initialRoll = true;
        okToRoll = true;
        okToPass = false;
    }

    
    /***************************************************************************************************************************
     * resets all values to 0
     * resets all dice and buttons for a new game
     **************************************************************************************************************************/
    public void resetGame(){
        for (Player p : players){
            p.newGame();
        }

        nextTurn();
    }

    
    /***************************************************************************************************************************
     * scores the player selected dice
     * sets the selected dice to scored
     **************************************************************************************************************************/
    public void scoreSelectedDice(){
        tallySelectedDice();

        if (hasStraight())
            currentPlayer.addToSubtotal(STRAIGHT);
        else{
            if (hasThreePairs())
                currentPlayer.addToSubtotal(THREE_PAIRS);
            else{
                for (int i = 0; i < NUM_DICE; i++){
                    if (tally[i] > 0)
                        currentPlayer.addToSubtotal(ofAKind[i][tally[i] - 1]);
                }
            }
        }

        for (GVdie d : theDice){
            if (d.isSelected()){
                d.setScored(true);
            }
        }
    }

    
    /***************************************************************************************************************************
     * rolls the not-scored, not-selected dice
     * can only roll if at least one die is selected
     **************************************************************************************************************************/
    public void rollDice(){
        if (initialRoll || !noDiceSelected()){
            scoreSelectedDice();
            boolean allScored = true;

            for (GVdie d : theDice){
                if (!d.isSelected() && !d.isScored()){
                    d.roll();
                }

                if (!d.isScored()){
                    allScored = false;
                }
            }
            
            if (allScored){
                for (GVdie d : theDice){
                    d.setSelected(false);
                    d.setScored(false);
                    d.roll();
                }
            }
        }

        if (playerFarkled()){
            okToRoll = false;
            currentPlayer.setSubtotal(0);
        }

        initialRoll = false;
        okToPass = true;
    }
    
    
    /***************************************************************************************************************************
     * passes the dice
     * ends the current players turn and updates scores
     *******************************************************************************************************************************/
    public void passDice(){
        scoreSelectedDice();
        currentPlayer.updateScore();
        nextTurn();
    }

    
    /***************************************************************************************************************************
     * @return whether the player is allowed to roll
     **************************************************************************************************************************/
    public boolean okToRoll(){
        return okToRoll;
    }

    
    /***************************************************************************************************************************
     * @return whether the player is allowed to pass
     **************************************************************************************************************************/
    public boolean okToPass(){
        return okToPass;
    }

    
    /***************************************************************************************************************************
     * returns true if there are no dice selected
     * @return if no dice are selected
     **************************************************************************************************************************/
    private boolean noDiceSelected(){
        for (GVdie d : theDice){
            if (d.isSelected()){
                return false;
            }
        }

        return true;
    }

    
    /***************************************************************************************************************************
     * checks if the current player as farkled
     * checks if any scores are possible with the remaining dice
     * @return if current player has farkled
     **************************************************************************************************************************/
    private boolean playerFarkled(){
        tallyUnscoredDice();
        okToRoll = true;
        okToPass = true;

        if (hasStraight())
            return false;

        if (hasThreePairs())
            return false;

        for (int i : tally){
            if (i == 3)
                return false;
            if (i == 4)
                return false;
            if (i == 5)
                return false;
            if (i == 6)
                return false;
        }

        if (tally[0] == 1 || tally[0] == 2)
            return false;

        if (tally[4] == 1 || tally[4] == 2)
            return false;

        okToRoll = false;
        return true;
    }

    
    /***************************************************************************************************************************
     * changes current player to specified player
     * @param player number
     **************************************************************************************************************************/
    public void setActivePlayer(int id){
        currentPlayer = players[id - 1];
    }

    
    /***************************************************************************************************************************
     * returns best player, read from file in constructor
     * @return best player
     **************************************************************************************************************************/
    public Player getBestPlayer(){
        return bestPlayer;
    }

    
    /***************************************************************************************************************************
     * changes the best player
     * @param new best player
     **************************************************************************************************************************/
    public void setBestPlayer(Player p){
        bestPlayer = p;
    }
    

    /***************************************************************************************************************************
     * sets all the dice to the array of inputs
     * only meant to be used for testing
     **************************************************************************************************************************/
    public void setAllDice(int[] values){
        if (values.length == 6){
            for (int i = 0; i < values.length; i++){
                if (values[i] < 1 || values[i] > 6)
                    values[i] = 1;

                theDice[i].roll();
                while(theDice[i].getValue() != values[i]){
                    theDice[i].roll();
                }
            }
        }else{
            System.out.print("Please enter an array of 6 numbers valued 1-6");
        }
    }

    /***************************************************************************************************************************
     * selects dice given an array of positions
     * only meant to be used for testing
     **************************************************************************************************************************/
    public void selectDie(int id){
        theDice[id - 1].setSelected(true);
    }
}