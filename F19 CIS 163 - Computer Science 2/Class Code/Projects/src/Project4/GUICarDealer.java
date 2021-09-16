package Project4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

/*****************************************************************
 *
 * Maintains the GUI1024 for the red box rental store
 *
 *****************************************************************/
public class GUICarDealer extends JFrame implements ActionListener {
    /**
     * Holds menu bar
     */
    private JMenuBar menus;

    /**
     * menus in the menu bar
     */
    private JMenu fileMenu;
    private JMenu actionMenu;

    /**
     * menu items in each of the menus
     */
    private JMenuItem openSerItem;
    private JMenuItem exitItem;
    private JMenuItem saveSerItem;
    private JMenuItem boughtCarItem;
    private JMenuItem boughtTruckItem;
    private JMenuItem Undo;

    private JMenuItem soldItem;

    /**
     * Holds the list engine
     */
    private ListEngine DList;
    private JPanel panel;

    /**
     * Holds JListArea
     */
    private JList jListArea;

    /** Scroll pane */
    //private JScrollPane scrollList;

    /*****************************************************************
     *
     * A constructor that starts a new GUI1024 for the rental store
     *
     *****************************************************************/
    public GUICarDealer() {
        //adding menu bar and menu items
        menus = new JMenuBar();
        fileMenu = new JMenu("File");
        actionMenu = new JMenu("Action");
        openSerItem = new JMenuItem("Open File");
        exitItem = new JMenuItem("Exit");
        saveSerItem = new JMenuItem("Save File");
        boughtCarItem = new JMenuItem("Bought a Car");
        boughtTruckItem = new JMenuItem("Bought a Truck");
        Undo = new JMenuItem("Undo");

        soldItem = new JMenuItem("Sold Car or Truck");

        //adding items to bar
        fileMenu.add(openSerItem);
        fileMenu.add(saveSerItem);
        fileMenu.add(exitItem);
        actionMenu.add(boughtCarItem);
        actionMenu.add(boughtTruckItem);

        actionMenu.add(soldItem);
        actionMenu.add(Undo);

        menus.add(fileMenu);
        menus.add(actionMenu);

        //adding actionListener
        openSerItem.addActionListener(this);
        saveSerItem.addActionListener(this);
        exitItem.addActionListener(this);
        boughtCarItem.addActionListener(this);
        boughtTruckItem.addActionListener(this);
        soldItem.addActionListener(this);
        Undo.addActionListener(this);

        setJMenuBar(menus);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        DList = new ListEngine();
        jListArea = new JList(DList);
        JScrollPane scrollList = new JScrollPane(jListArea);
        scrollList.setPreferredSize(new Dimension(800, 300));
        panel.add(scrollList);

        add(panel, BorderLayout.CENTER);

        setVisible(true);
        setSize(950, 450);
    }

    /*****************************************************************
     *
     * This method handles event-handling code for the GUI1024
     *
     * @param e - Holds the action event parameter
     *****************************************************************/
    public void actionPerformed(ActionEvent e) {

        Object comp = e.getSource();

        if (openSerItem == comp) {
            JFileChooser chooser = new JFileChooser();
            int status = chooser.showOpenDialog(null);
            if (status == JFileChooser.APPROVE_OPTION) {
                String filename = chooser.getSelectedFile().getAbsolutePath();
                if (openSerItem == comp)
                    DList.loadDatabase(filename);
            }
        }

        if (saveSerItem == comp) {
            JFileChooser chooser = new JFileChooser();
            int status = chooser.showSaveDialog(null);
            if (status == JFileChooser.APPROVE_OPTION) {
                String filename = chooser.getSelectedFile().getAbsolutePath();
                if (saveSerItem == e.getSource())
                    DList.saveDatabase(filename);
            }
        }

        if (e.getSource() == Undo){
            DList.undo();
        }
        //MenuBar options
        if (e.getSource() == exitItem) {
            System.exit(1);
        }

        if (e.getSource() == boughtCarItem) {
            Car car = new Car();
            BoughtCarDialog dialog = new BoughtCarDialog(this, car);
            if (dialog.getCloseStatus() == BoughtCarDialog.OK) {
                DList.add(car);
                DList.addTo2ndLinked(car, 1);
            }
        }

        if (e.getSource() == boughtTruckItem) {
            Truck truck = new Truck();
            BoughtTruckDialog dialog = new BoughtTruckDialog(this, truck);
            if (dialog.getCloseStatus() == BoughtTruckDialog.OK) {
                DList.add(truck);
                DList.addTo2ndLinked(truck, 1);
            }
        }

        if (soldItem == e.getSource()) {
            int index = jListArea.getSelectedIndex();
            if (index != -1) {
                GregorianCalendar dat = new GregorianCalendar();

                Auto unit = DList.get(index);
                SoldOnDialog dialog = new SoldOnDialog(this, unit);
                if (dialog.getCloseStatus() == SoldOnDialog.OK) {
                    unit = DList.remove(index);
                    DList.addTo2ndLinked(unit, 0);

                    JOptionPane.showMessageDialog(null, "For the sales person, " +
                            "\n Sold the " + unit.getAutoName() +
                            ", the price difference was:  " +
                            unit.getBoughtSoldCost(null, unit.getSoldPrice()) +
                            " dollars");
                }
            }
        }
    }

    public static void main(String[] args) {
        new GUICarDealer();
    }
}
