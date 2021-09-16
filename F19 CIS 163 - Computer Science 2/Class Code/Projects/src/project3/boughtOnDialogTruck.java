package project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/************************************************************************
 *  This program allows users to purchase a truck and makes sure users
 *  enter valid entries.
 *
 * @author Justin Von Kulajta Winn and Nick Layman
 * @version 1.8
 ************************************************************************/

public class boughtOnDialogTruck extends JDialog implements ActionListener {

    /** This is the text field that represents the truck title */
    private JTextField txtName;

    /** This is the text field that represents the truck's purchase date */
    private JTextField txtDate;

    /** This is the text field that represents the truck's trim package */
    private JTextField txtTrimPackage;

    /** This is the boolean that determines if the truck is a four by four */
    private JTextField txtFourbyFour;

    /** This is the text field that represents the truck's cost */
    private JTextField txtCost;

    /** This is the button that represents the 'ok' button */
    private JButton okButton;

    /** This is the button that represents the 'cancel' button */
    private JButton cancelButton;

    /** This is the J combo box that represents the select menu for which vehicle */
    private JComboBox<String> combobox;

    /** This is the integer that represents if the window should close or not */
    private int closeStatus;

    /** This is the auto being built by the user */
    private Auto auto;

    /** This is the integer that represents the action of the OK being pressed */
    static final int OK = 0;

    /** This is the integer that represents the action of the CANCEL being pressed */
    static final int CANCEL = 1;

    /** This is the array that holds the number of days in each month */
    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31,
            31, 30, 31, 30, 31};

    /************************************************************************
     * Instantiate a Custom Dialog as 'modal' and wait for the
     * user to provide data and click on a button.
     * @param parent reference to the JFrame application
     * @param auto an instantiated object to be filled with data
     ************************************************************************/
    public boughtOnDialogTruck(JFrame parent, Auto auto) {
        // call parent and create a 'modal' dialog
        super(parent, true);

        this.auto = auto;
        setTitle("Buying A Truck");
        closeStatus = CANCEL;
        setSize(400,200);

        // prevent user from closing window
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        // instantiate and display two text fields
        txtName = new JTextField("F150",30);
        txtDate = new JTextField(15);
        txtFourbyFour = new JTextField("True",15);
        txtTrimPackage = new JTextField("LT",15);
        txtCost = new JTextField("10100.00", 15);

        String[] autoStrings = { "Truck"};

        combobox = new JComboBox<>(autoStrings);
        txtDate.setText("10/17/2018");
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(7,2));

        textPanel.add(new JLabel(""));
        textPanel.add(combobox);
        textPanel.add(new JLabel(""));
        textPanel.add(new JLabel(""));

        textPanel.add(new JLabel("Name of Car: "));
        textPanel.add(txtName);
        textPanel.add(new JLabel("bought on Date: "));
        textPanel.add(txtDate);
        textPanel.add(new JLabel("Trim Package"));
        textPanel.add(txtTrimPackage);
        textPanel.add(new JLabel("Four by Four"));
        textPanel.add(txtFourbyFour);
        textPanel.add(new JLabel("Amount Paid for"));
        textPanel.add(txtCost);

        getContentPane().add(textPanel, BorderLayout.CENTER);

        // Instantiate and display two buttons
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);

        setVisible (true);
    }

    /************************************************************************
     * This function activates when a button has been pressed on the dialog
     * box
     * @param e is used to check what button has been pressed
     ***********************************************************************/
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();

        // if OK clicked the fill the object
        if (button == okButton) {
            // save the information in the object
            closeStatus = OK;
            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            GregorianCalendar temp = new GregorianCalendar();
            String tempName;
            double tempCost;
            String tempDate;
            int day;
            int month;
            int year;

            try {
                tempName = txtName.getText();
                tempCost = Double.parseDouble(txtCost.getText());
                String[] dates = txtDate.getText().split("/");
                String months;
                String days;
                String years;
                if (dates.length == 3){
                    months = dates[0];
                    days = dates[1];
                    years = dates[2];
                }
                else
                    throw new IllegalArgumentException();

                month = Integer.parseInt(months);//Converts the Strings into integers
                day = Integer.parseInt(days);
                year = Integer.parseInt(years);
                if (month < 1 || day < 1 || year < 1950 || month > 12)
                    throw new IllegalArgumentException();

                if (!isLeapYear(year)) {
                    if (day > DAYS_IN_MONTH[month])
                        throw new IllegalArgumentException();
                }
                else if (month == 2 && day > 29) {
                    throw new IllegalArgumentException();
                }

                if (tempName.equals(""))
                    throw new Exception();
                if (tempCost <= 0)
                    throw new NumberFormatException();
            }
            catch (NumberFormatException e2){
                JOptionPane.showMessageDialog(null, "Enter a cost above 0");
                return;
            }
            catch (IllegalArgumentException e5){
                JOptionPane.showMessageDialog(null,
                        "Enter a correct date with the format month/day/year");
                return;
            }
            catch (Exception e3){
                JOptionPane.showMessageDialog(null, "Enter the name of the Truck");
                return;
            }

            if (combobox.getSelectedIndex() == 1) {
                Date d = null;
                try {
                    d = df.parse(txtDate.getText());
                    temp.setTime(d);

                } catch (ParseException e1) {
                    JOptionPane.showMessageDialog(null, "Invalid Date");
                    //unreachable because the date is checked before this
                }
                auto.setBoughtOn(temp);
                auto.setAutoName(txtName.getText());
                ((Truck) auto).setTrim(txtTrimPackage.getText());
                auto.setBoughtCost(Double.parseDouble(txtCost.getText()));

            }

            else {
                Date d = null;
                try {
                    d = df.parse(txtDate.getText());
                    temp.setTime(d);

                } catch (ParseException e1) {
                    JOptionPane.showMessageDialog(null, "Invalid Date");
                    //unreachable because the date is checked before this
                }

                auto.setBoughtOn(temp);
                auto.setAutoName(txtName.getText());
                auto.setBoughtCost(Double.parseDouble(txtCost.getText()));
                ((Truck) auto).setTrim(txtTrimPackage.getText());

                if (txtFourbyFour.getText().equalsIgnoreCase("true"))
                    ((Truck) auto).setFourByFour(true);
                else
                    ((Truck) auto).setFourByFour(false);
            }

        }

        if (button == cancelButton){
            txtCost.setText("50000");
        }

        // make the dialog disappear
        dispose();
    }

    /************************************************************************
     * This function returns the current close status
     * @return the integer representing the current close status
     ***********************************************************************/
    public int getCloseStatus(){
        return closeStatus;
    }

    /************************************************************************
     * This function determines if the year passed is leap year or not.
     * @param year is the year that is checked if it is a leap year or not
     * @return true if it is a leap year, false if it is not a leap year
     ***********************************************************************/
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
}