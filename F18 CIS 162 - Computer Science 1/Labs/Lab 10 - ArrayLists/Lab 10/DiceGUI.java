import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/***************************************************************
 * GUI for rolling dice
 * 
 * @author Larry Kotman 
 * @version Februrary 14, 2015
 * @updated April 2016 - to add functionality to use tally.
 ***************************************************************/

public class DiceGUI extends JFrame implements ActionListener{
    /** dice */
    private Dice dice;

    /** buttons */
    private JButton rollBtn;
    private JButton exitBtn;
    // private JButton tallyBtn;

    /*********************
     * DiceGUI constructor
     *********************/
    public DiceGUI( ){ 

        // prompt for number of dice
        String text = JOptionPane.showInputDialog(this, "Number of dice?");
        if(text.length() == 0)
            System.exit(1);
        int count = Integer.parseInt(text);

        // Create dice 
        dice = new Dice(count);

        // Set up the GridBag Layout
        setLayout(new GridBagLayout());
        GridBagConstraints loc = new GridBagConstraints();

        // Create buttons
        rollBtn = new JButton( "Roll" );
        rollBtn.addActionListener(this);
        exitBtn = new JButton( "Exit" );
        exitBtn.addActionListener(this);
        // tallyBtn = new JButton( "Tally" );
        // tallyBtn.addActionListener(this);

        // place the buttons in the top row of the grid
        loc.gridy = 0;
        loc.gridx = 0;
        add( rollBtn, loc);
        loc.gridx = 1;
        add( exitBtn, loc);
        loc.gridx = 2;
        // add( tallyBtn, loc);

        ArrayList <GVdie> d = dice.getDice();
        // place the dice ten per row
        int row=1;
        int col=0;
        for (int n = 0; n < d.size(); n++){
            loc.gridx = col;
            loc.gridy = row;
            add(d.get(n), loc); 
            col++;
            if (col%10 == 0){
                col = 0;
                row++;
            }
        }

    }

    /******************************************************
    Respond to the user action from
     ******************************************************/
    public void actionPerformed(ActionEvent e){

        if (e.getSource() == rollBtn){
            dice.roll( );
            JOptionPane.showMessageDialog( null, "Total: " + dice.getTotal()); 
        }

        if (e.getSource() == exitBtn){
            System.exit( 1 );
        }

        // if (e.getSource() == tallyBtn)
            // JOptionPane.showMessageDialog( null, "Tally: " + dice.showValues( )); 
    }

    /**************************************************
     * Create the GUI, for an event driven application 
     **************************************************/    
    public static void main( String[ ] args ){
        DiceGUI gui = new DiceGUI( );
        gui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        gui.setLocation(300, 300);
        gui.setTitle("Dice Lab");
        gui.pack( );
        gui.setVisible(true);           
    }

}
