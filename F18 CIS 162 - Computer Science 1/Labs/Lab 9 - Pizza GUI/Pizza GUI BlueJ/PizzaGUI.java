import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
/*******************************************************
 * Demonstration of GUI components and Action Listeners
 * using a pizza order form
 * 
 * @author Scott Grissom
 * @version May 5, 2018
 ******************************************************/
public class PizzaGUI extends JFrame implements ActionListener{

    // FIX ME: add additional radio buttons for sizes and crust options
    private JRadioButton smallRadio, mediumRadio, largeRadio, partyRadio;
    //private JRadioButton large, party;
    private JRadioButton thinRadio, thickRadio, panRadio, stuffedRadio;
    //private JRadioButton pan, stuffed;
    
    // FIX ME: add additional check boxes for meats and veggies
    private JCheckBox sausageCheck, pepperoniCheck, baconCheck, hamCheck;
    private JCheckBox peppersCheck, onionsCheck, olivesCheck, 
            pineappleCheck, spinachCheck, broccoliCheck;
    
    private JLabel priceLbl;
    private JButton priceBtn;
    private JButton orderBtn;
    private PizzaOrder theOrder;

    /** menu items to display about and to quit */
    JMenuItem quitItem;
    JMenuItem aboutItem;

/*****************************************************
This is a standard main method that creates and displays
the GUI.
****************************************************/
    public static void main(String args[]){
        PizzaGUI frame = new PizzaGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }  

/****************************************************
Constructor
****************************************************/  
    public PizzaGUI(){

        // FIX ME: Instantiate the PizzaOrder object
        theOrder = new PizzaOrder();
        
        // FIX ME: create your own title
        setTitle("GVSU Pizza");

        // hide away details of creating menus
        setupMenus();
        
        // set layout manager and fonts
        setLayout(new GridBagLayout());
        GridBagConstraints position = new GridBagConstraints();
        Font myFont = new Font("serif", Font.BOLD, 20); 
        
        // make components left justified with padding on right
        position.anchor = GridBagConstraints.LINE_START;
        position.insets = new Insets(0,0,00,20);        

        // create radio buttons for size      
        smallRadio = new JRadioButton("Small", true);
        mediumRadio = new JRadioButton("Medium");
        largeRadio = new JRadioButton("Large");
        partyRadio = new JRadioButton("Party");
        
        
        // combine radio buttons in a group
        ButtonGroup sizesGroup = new ButtonGroup();
        sizesGroup.add(smallRadio);
        sizesGroup.add(mediumRadio);
        sizesGroup.add(largeRadio);
        sizesGroup.add(partyRadio);

        // Place radio buttons for size
        JLabel sizeLbl = new JLabel("Pick Size");
        sizeLbl.setFont(myFont);
        position.gridy = 0;
        position.gridx = 1; 
        add(sizeLbl, position);       
        position.gridy = 1; 
        add(smallRadio, position);
        position.gridy = 2; 
        add(mediumRadio, position);
        position.gridy = 3;
        add(largeRadio, position);
        position.gridy = 4;
        add(partyRadio, position);

        // Create radio buttons for crust
        thinRadio = new JRadioButton("Thin", true);
        thickRadio = new JRadioButton("Thick");
        panRadio = new JRadioButton("Pan");
        stuffedRadio = new JRadioButton("Stuffed");
        
        // combine radio buttons in a group
        ButtonGroup crustGroup = new ButtonGroup();
        crustGroup.add(thinRadio);
        crustGroup.add(thickRadio);
        crustGroup.add(panRadio);
        crustGroup.add(stuffedRadio);

        // Place radio buttons for crust
        JLabel crustLbl = new JLabel("Pick Crust");
        crustLbl.setFont(myFont);
        position.gridy = 0;
        position.gridx = 2; 
        add(crustLbl, position);        
        position.gridy = 1;
        add(thinRadio, position);
        position.gridy = 2;
        add(thickRadio, position);
        position.gridy = 3;
        add(panRadio, position);
        position.gridy = 4;
        add(stuffedRadio, position);

        // Create checkboxes for meat toppings
        sausageCheck = new JCheckBox("Sausage");
        pepperoniCheck = new JCheckBox("Pepperoni");  
        baconCheck = new JCheckBox("Bacon");
        hamCheck = new JCheckBox("Ham");
   
        // Place checkboxes for meat
        JLabel meatLbl = new JLabel("Pick Meat");
        meatLbl.setFont(myFont);
        position.gridy = 0;
        position.gridx = 3; 
        add(meatLbl,position);          
        position.gridy = 1;
        add(sausageCheck, position);
        position.gridy = 2;        
        add(pepperoniCheck, position);  
        position.gridy = 3;
        add(baconCheck, position);
        position.gridy = 4;
        add(hamCheck, position);

        // create checkboxes for veggie choices
        onionsCheck = new JCheckBox("Onions");
        peppersCheck = new JCheckBox("Peppers");  
        olivesCheck = new JCheckBox("Olives");
        pineappleCheck = new JCheckBox("Pineapple");
        spinachCheck = new JCheckBox("Spinach");
        broccoliCheck = new JCheckBox("Broccoli");
        
        // display checkboxes for veggies
        JLabel vegLbl = new JLabel("Pick Veggie");
        vegLbl.setFont(myFont);
        position.gridy = 0;
        position.gridx = 4;  
        add(vegLbl,position);          
        position.gridy = 1;
        add(peppersCheck, position);
        position.gridy = 2;        
        add(onionsCheck, position);  
        position.gridy = 3;
        add(olivesCheck, position);
        position.gridy = 4;
        add(pineappleCheck, position);
        position.gridy = 5;
        add(spinachCheck, position);
        position.gridy = 6;
        add(broccoliCheck, position);

        // display price
        JLabel priceTitle = new JLabel("Price");
        position.gridy = 0;
        position.gridx = 5;         
        priceTitle.setFont(myFont);
        add(priceTitle,position);
        priceLbl = new JLabel("$0.00");
        priceLbl.setFont(myFont);
        position.gridy = 1;
        add(priceLbl,position);

        // create and display the Price button
        priceBtn = new JButton("Price");
        position.gridx = 5; 
        position.gridy = 2;
        add(priceBtn,position);
        priceBtn.addActionListener(this);
        
        // FIX ME: create and display the Order button
        orderBtn = new JButton("Order");
        position.gridy = 4;
        add(orderBtn, position);
        orderBtn.addActionListener(this);
        
        // display an image of pizza
        // FIX ME: update the file name
        ImageIcon icon = new ImageIcon("pizza1.jpg");
        JLabel imageLabel =new JLabel(icon);
        position.gridy = 0;
        position.gridx = 0; 
        position.gridheight = 10;
        add(imageLabel, position);
    }

/********************************************************
Process each button click or menu selection
********************************************************/    
    public void actionPerformed(ActionEvent event){      
        
        // Calculate price based on selected options
        if(event.getSource() == priceBtn){
            
            // review order selections
            updatePizzaOrder();
            
            // display updated price
            NumberFormat fmt = NumberFormat.getCurrencyInstance(); 
            priceLbl.setText(fmt.format(theOrder.getPrice()));    
        }
        
        // FIX ME: process menu item for Quit
        if(event.getSource() == quitItem){
            // close application
            System.exit(0);
        }
        
        // FIX ME: process menu item for About
        if (event.getSource() == aboutItem)
            JOptionPane.showMessageDialog(this, "Nick Layman");
        
        // FIX ME: process button for Order
        if (event.getSource() == orderBtn){
            String summary = theOrder.getOrder();
            JOptionPane.showMessageDialog(this, summary);
        }
        }
    

/************************************************************
Hide details of updating all order options
************************************************************/
    private void updatePizzaOrder(){
            
            theOrder.clearOrder();

            if (smallRadio.isSelected()){
                theOrder.setSize(PizzaOrder.SMALL);
            }
            
            // FIX ME: add if statements for other sizes
            if (mediumRadio.isSelected())
                theOrder.setSize(PizzaOrder.MEDIUM);
                
            if (largeRadio.isSelected())
                theOrder.setSize(PizzaOrder.LARGE);
                
            if (partyRadio.isSelected())
                theOrder.setSize(PizzaOrder.PARTY);
            
            
            if (thinRadio.isSelected()){
                theOrder.setCrust(PizzaOrder.THIN);
            }  
            
            // FIX ME: add if statements for other crusts 
            if (thickRadio.isSelected())
                theOrder.setCrust(PizzaOrder.THICK);
                
            if (panRadio.isSelected())
                theOrder.setCrust(PizzaOrder.PAN);
                
            if (stuffedRadio.isSelected())
                theOrder.setCrust(PizzaOrder.STUFFED);
            
            // FIX ME: add if statements for each meat option
            if (pepperoniCheck.isSelected()){
                theOrder.addMeat();
            }  
            
            if (sausageCheck.isSelected())
                theOrder.addMeat();
                
            if (baconCheck.isSelected())
                theOrder.addMeat();
                
            if (hamCheck.isSelected())
                theOrder.addMeat();
            
            // FIX ME: add if statements for each veggie option
            if (onionsCheck.isSelected()){
                theOrder.addVeggie();
            }         
            
            if (peppersCheck.isSelected())
                theOrder.addVeggie();
                
            if (olivesCheck.isSelected())
                theOrder.addVeggie();
                
            if (pineappleCheck.isSelected())
                theOrder.addVeggie();
                
            if (spinachCheck.isSelected())
                theOrder.addVeggie();
                
            if (broccoliCheck.isSelected())
                theOrder.addVeggie();
        
    }    
/************************************************************
Setup the file menu with two options: about and quit
Menu items must register their action listeners
************************************************************/
    private void setupMenus (){

        // create and display the menu bar
        JMenuBar menusBar = new JMenuBar();
        setJMenuBar(menusBar);

        // create a menu and add to the menubar
        JMenu fileMenu = new JMenu("File");
        menusBar.add(fileMenu);

        // FIX ME: create a menu item for About (see below) 
        aboutItem = new JMenuItem("About...");
        fileMenu.add(aboutItem);
        aboutItem.addActionListener(this);
        
        // create a menu item for Quit
        quitItem = new JMenuItem("Quit");
        fileMenu.add(quitItem);
        quitItem.addActionListener(this);  
    }
}