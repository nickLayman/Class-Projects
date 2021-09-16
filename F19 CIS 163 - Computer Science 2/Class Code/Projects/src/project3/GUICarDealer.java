package project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*****************************************************************
 *
 * Maintains the GUI1024 for the red box rental store
 *
 *****************************************************************/
public class GUICarDealer extends JFrame implements ActionListener{
    /** Holds menu bar */
    private JMenuBar menus;

    /** menus in the menu bar */
    private JMenu fileMenu;
    private JMenu actionMenu;

    /** menu items in each of the menus */
    private JMenuItem openSerItem;
    private JMenuItem exitItem;
    private JMenuItem saveSerItem;
    private JMenuItem saveTextItem;
    private JMenuItem boughtCarItem;
    private JMenuItem boughtTruckItem;

    private JMenuItem saveText;
    private JMenuItem openText;
    private JMenuItem boughtScreen;
    private JMenuItem soldScreen;
    private JMenuItem overDueScreen;


    private JMenuItem soldItem;

    /** Holds the list engine */
    private ListEngine DList;
    private JPanel panel;

    /** Holds JListArea */
    private JTable jListArea;

    /** Scroll pane */
    //private JScrollPane scrollList;

    /*****************************************************************
     *
     * A constructor that starts a new GUI1024 for the rental store
     *
     *****************************************************************/
    public GUICarDealer(){
        //adding menu bar and menu items
        menus = new JMenuBar();
        fileMenu = new JMenu("File");
        actionMenu = new JMenu("Action");
        openSerItem = new JMenuItem("Open File");
        exitItem = new JMenuItem("Exit");
        saveSerItem = new JMenuItem("Save File");
        boughtTruckItem = new JMenuItem("Bought at auction a Truck");
        boughtCarItem = new JMenuItem("Bought at auction a Car");


        soldItem = new JMenuItem("Sold Car or Truck");
        openText = new JMenuItem("Open Text");
        saveText = new JMenuItem("Save Text");
        boughtScreen = new JMenuItem("Bought Screen");
        soldScreen = new JMenuItem("Sold Screen");
        overDueScreen = new JMenuItem("30 Days overDue Screen");

        //adding items to bar
        fileMenu.add(openSerItem);
        fileMenu.add(saveSerItem);
        fileMenu.add(openText);
        fileMenu.add(saveText);
        fileMenu.add(exitItem);
        fileMenu.add(boughtScreen);
        fileMenu.add(soldScreen);
        fileMenu.add(overDueScreen);

        actionMenu.add(boughtTruckItem);
        actionMenu.add(boughtCarItem);
        actionMenu.add(soldItem);

        menus.add(fileMenu);
        menus.add(actionMenu);

        //adding actionListener
        openSerItem.addActionListener(this);
        saveSerItem.addActionListener(this);
        exitItem.addActionListener(this);
        boughtTruckItem.addActionListener(this);
        boughtCarItem.addActionListener(this);
        soldItem.addActionListener(this);
        openText.addActionListener(this);
        saveText.addActionListener(this);
        boughtScreen.addActionListener(this);
        soldScreen.addActionListener(this);
        overDueScreen.addActionListener(this);

        setJMenuBar(menus);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        DList = new ListEngine();
        jListArea = new JTable(DList);
        JScrollPane scrollList = new JScrollPane(jListArea);
        scrollList.setPreferredSize(new Dimension(800,300));
        panel.add(scrollList);

        add(panel, BorderLayout.CENTER);

        setVisible(true);
        setSize(950,450);
    }

    /*****************************************************************
     *
     * This method handles event-handling code for the GUI1024
     *
     * @param e - Holds the action event parameter
     *****************************************************************/
    public void actionPerformed(ActionEvent e) {

        Object comp = e.getSource();

        if (saveSerItem == comp || saveTextItem == comp) {
            JFileChooser chooser = new JFileChooser();
            int status = chooser.showSaveDialog(null);
            if (status == JFileChooser.APPROVE_OPTION) {
                String filename = chooser.getSelectedFile().getAbsolutePath();
                if (saveSerItem == e.getSource())
                    DList.saveDatabase(filename);
            }
        }

        //MenuBar options
        if(e.getSource() == boughtTruckItem){
            Auto auto = new Truck();
            boughtOnDialogTruck dialog = new boughtOnDialogTruck(this, auto);
            if(dialog.getCloseStatus() == boughtOnDialogCar.OK){
                DList.add(auto);
            }
            DList.updateDisplay(DList.displayValue);
        }

        if(boughtCarItem == e.getSource()){
            Auto auto1 = new Car();
            boughtOnDialogCar dialog = new boughtOnDialogCar(this, auto1);
            if(dialog.getCloseStatus() == boughtOnDialogCar.OK)
                DList.add(auto1);
            DList.updateDisplay(DList.displayValue);
        }

        if (soldItem == e.getSource()) {
            int index = jListArea.getSelectedRow();
            if (index >= 0) {
                Auto unit = DList.get(index);
                soldOnDialog dialog = new soldOnDialog(this, unit);
                DList.updateDisplay(DList.displayValue);
            }
            else
                JOptionPane.showMessageDialog(null, "Please select an auto to sell");
        }

        if (openText == e.getSource()){
            DList.loadFromText("saved");
        }

        if (saveText == e.getSource()){
            DList.saveAsText("saved");
        }

        if (boughtScreen  == e.getSource()){
            DList.updateDisplay(DList.boughtScreen);
            boughtCarItem.setEnabled(true);
            boughtTruckItem.setEnabled(true);
            soldItem.setEnabled(true);
        }

        if (soldScreen == e.getSource()){
            DList.updateDisplay(DList.soldScreen);
            boughtCarItem.setEnabled(false);
            boughtTruckItem.setEnabled(false);
            soldItem.setEnabled(false);
        }

        if (overDueScreen == e.getSource()){
            DList.updateDisplay(DList.overdueScreen);
            boughtCarItem.setEnabled(false);
            boughtTruckItem.setEnabled(false);
            soldItem.setEnabled(true);
        }
        if (exitItem == e.getSource())
            System.exit(-1);
    }


    public static void main(String[] args) {
        new GUICarDealer();
    }
}