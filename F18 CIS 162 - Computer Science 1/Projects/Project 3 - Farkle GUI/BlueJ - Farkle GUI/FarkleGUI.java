import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.*;

/*************************
 * GUI for Farkle game
 *
 * @author Nick Layman
 * @version 11/5/2018
 *************************/

public class FarkleGUI extends JFrame implements ActionListener{
    /** the farkle game rules and gameplay */
    private FarkleStub theGame; 
    
    /** the current player */
    private Player currentPlayer;
    
    /** menu items: new game, best score, and quit */
    private JMenuItem newGame;
    private JMenuItem bestScore;
    private JMenuItem quit;
    
    /** first player labels */
    private JRadioButton player1Name;
    private JLabel player1Turns;
    private JLabel player1Subtotal;
    private JLabel player1Score;
    
    /** second player labels */
    private JRadioButton player2Name;
    private JLabel player2Turns;
    private JLabel player2Subtotal;
    private JLabel player2Score;
    
    /** third player and labels */
    private JRadioButton player3Name;
    private JLabel player3Turns;
    private JLabel player3Subtotal;
    private JLabel player3Score;
    
    /** gameplay options, roll or pass dice */
    private JButton rollButton;
    private JButton passButton;
    
    
    /****************************************************
     * Constructor creates the main layout for the GUI
     ****************************************************/  
    public FarkleGUI(){
        theGame = new FarkleStub();
        
        /** sets up all menus - helper method */
        setupMenu();
        
        /** set layout manager and font */
        setLayout(new GridBagLayout());
        GridBagConstraints position = new GridBagConstraints();
        
        /** make components left justified with padding on right */
        position.anchor = GridBagConstraints.LINE_START;
        position.insets = new Insets(0,0,0,20);
        
        /** create radio button to indicate current player */
        player1Name = new JRadioButton("Player 1", true);
        player2Name = new JRadioButton("Player 2");
        player3Name = new JRadioButton("Player 3");
        
        /** create gameplay buttons to roll and pass dice */
        rollButton = new JButton("Roll");
        passButton = new JButton("Pass");
        
        /** get the dice ArrayLst from the game */
        ArrayList<GVdie> theDice = theGame.getDice();
        
        /** place dice on the GUI */
        position.gridy = 0;
        position.gridx = 0;
        for (int i = 0; i < 6; i++){
            add(theDice.get(i), position);
            position.gridx++;
        }
        
        /** place roll and pass buttons on the GUI*/
        position.gridy = 2;
        position.gridx = 1;
        add(rollButton, position);
        rollButton.addActionListener(this);
        rollButton.setEnabled(true);
        position.gridx = 2;
        add(passButton, position);
        passButton.addActionListener(this);
        passButton.setEnabled(false);
        
        /** combine player names into a group */
        ButtonGroup namesGroup = new ButtonGroup();
        namesGroup.add(player1Name);
        namesGroup.add(player2Name);
        namesGroup.add(player3Name);
        
        /** place player names on the GUI */
        position.gridx = 3;
        position.gridy = 1;
        add(player1Name, position);
        player1Name.addActionListener(this);
        position.gridx = 4;
        add(player2Name, position);
        player2Name.addActionListener(this);
        position.gridx = 5;
        add(player3Name, position);
        player3Name.addActionListener(this);
        
        /** create labels for each player */
        player1Turns = new JLabel();
        player1Subtotal = new JLabel();
        player1Score = new JLabel();
        
        player2Turns = new JLabel();
        player2Subtotal = new JLabel();
        player2Score = new JLabel();
        
        player3Turns = new JLabel();
        player3Subtotal = new JLabel();
        player3Score = new JLabel();
        
        /** place all player labels on the GUI */
        position.gridx = 3;
        position.gridy = 2;
        add(player1Turns, position);
        position.gridy = 3;
        add(player1Subtotal, position);
        position.gridy = 4;
        add(player1Score, position);
        
        position.gridx = 4;
        position.gridy = 2;
        add(player2Turns, position);
        position.gridy = 3;
        add(player2Subtotal, position);
        position.gridy = 4;
        add(player2Score, position);
        
        position.gridx = 5;
        position.gridy = 2;
        add(player3Turns, position);
        position.gridy = 3;
        add(player3Subtotal, position);
        position.gridy = 4;
        add(player3Score, position);
        
        newGame();
    }
    
    
    /********************************************************
     * Process each button click or menu selection
     ********************************************************/    
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == rollButton){
            theGame.rollDice();
            if (!theGame.okToRoll()){
                JOptionPane.showMessageDialog(this, "Farkle");
            }
        }
        
        if (event.getSource() == passButton){
            theGame.passDice();
        }
        
        if (event.getSource() == quit){
            System.exit(0);
        }
        
        if (event.getSource() == bestScore){
            Player best = theGame.getBestPlayer();
            JOptionPane.showMessageDialog(this, 
                "Player: " + best.getName() + "\n" + 
                "Score: " + best.getScore() + "\n" +
                "Turns: " + best.getTurns());
        }
        
        if (event.getSource() == newGame){
            newGame();
        }
        
        if (event.getSource() == player1Name){
            theGame.setActivePlayer(1);
            currentPlayer = theGame.getActivePlayer();
        }
        
        if (event.getSource() == player2Name){
            theGame.setActivePlayer(2);
            currentPlayer = theGame.getActivePlayer();
        }
        
        if (event.getSource() == player3Name){
            theGame.setActivePlayer(3);
            currentPlayer = theGame.getActivePlayer();
        }
        
        if (theGame.okToRoll()){
            rollButton.setEnabled(true);
        }
        else{
            rollButton.setEnabled(false);
        }
        
        if (theGame.okToPass()){
            passButton.setEnabled(true);
        }
        else{
            passButton.setEnabled(false);
        }
        
        if (player1Name.isSelected()){
            theGame.setActivePlayer(1);
            currentPlayer = theGame.getActivePlayer();
            player1Subtotal.setText("Sub Total: " + currentPlayer.getSubtotal());
            player1Score.setText("Score: " + currentPlayer.getScore());
            player1Turns.setText("Turns: " + currentPlayer.getTurns());
        }
        
        if (player2Name.isSelected()){
            theGame.setActivePlayer(2);
            currentPlayer = theGame.getActivePlayer();
            player2Subtotal.setText("Sub Total: " + currentPlayer.getSubtotal());
            player2Score.setText("Score: " + currentPlayer.getScore());
            player2Turns.setText("Turns: " + currentPlayer.getTurns());
        }
        
        if (player3Name.isSelected()){
            theGame.setActivePlayer(3);
            currentPlayer = theGame.getActivePlayer();
            player3Subtotal.setText("Sub Total: " + currentPlayer.getSubtotal());
            player3Score.setText("Score: " + currentPlayer.getScore());
            player3Turns.setText("Turns: " + currentPlayer.getTurns());
        }
        
        if (theGame.gameOver()){
            rollButton.setEnabled(false);
            passButton.setEnabled(false);
            JOptionPane.showMessageDialog(this, currentPlayer.getName() + " Wins!");
        }
    }
    
    
    /**************************************************
     * Setup the file menu with three options: 
     * new game, best score, and quit
     **************************************************/
    private void setupMenu(){
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        
        newGame = new JMenuItem("New Game");
        fileMenu.add(newGame);
        newGame.addActionListener(this);
        
        bestScore = new JMenuItem("Best Score");
        fileMenu.add(bestScore);
        bestScore.addActionListener(this);
        
        quit = new JMenuItem("Quit");
        fileMenu.add(quit);
        quit.addActionListener(this);
    }
    
    
    /************************************************************
     * helper method to start a new game
     * resets all player's scores, subtotals, and turns to 0 and
     * resets the game from theGame
     ***********************************************************/
    private void newGame(){
        theGame.resetGame();
        
        theGame.setActivePlayer(1);
        currentPlayer = theGame.getActivePlayer();
        player1Name.setText(currentPlayer.getName());
        player1Subtotal.setText("Sub Total: " + currentPlayer.getSubtotal());
        player1Turns.setText("Turns: " + currentPlayer.getTurns());
        player1Score.setText("Score: " + currentPlayer.getScore());
        
        theGame.setActivePlayer(2);
        currentPlayer = theGame.getActivePlayer();
        player2Name.setText(currentPlayer.getName());
        player2Subtotal.setText("Sub Total: " + currentPlayer.getSubtotal());
        player2Turns.setText("Turns: " + currentPlayer.getTurns());
        player2Score.setText("Score: " + currentPlayer.getScore());
        
        theGame.setActivePlayer(3);
        currentPlayer = theGame.getActivePlayer();
        player3Name.setText(currentPlayer.getName());
        player3Subtotal.setText("Sub Total: " + currentPlayer.getSubtotal());
        player3Turns.setText("Turns: " + currentPlayer.getTurns());
        player3Score.setText("Score: " + currentPlayer.getScore());
    }
    
    
    /*****************************************************
     * This is a standard main method that creates and displays
     * the GUI.
     ****************************************************/
    public static void main(String args[]){
        FarkleGUI frame = new FarkleGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }  
}
