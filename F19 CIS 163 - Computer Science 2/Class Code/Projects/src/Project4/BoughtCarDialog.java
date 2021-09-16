package Project4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BoughtCarDialog extends JDialog implements ActionListener {
    private JTextField txtName;
    private JTextField txtDate;
    private JTextField txtTrimPackage;
    private JTextField txtTurbo;
    private JTextField txtCost;
    private JButton okButton;
    private JButton cancelButton;
    private int closeStatus;
    private Car car;
    static final int OK = 0;
    static final int CANCEL = 1;

    /*********************************************************
     Instantiate a Custom Dialog as 'modal' and wait for the
     user to provide data and click on a button.

     @param parent reference to the JFrame application
     @param car an instantiated object to be filled with data
     *********************************************************/

    public BoughtCarDialog(JFrame parent, Car car) {
        // call parent and create a 'modal' dialog
        super(parent, true);

        this.car = car;
        setTitle("Bought car dialog box");
        closeStatus = CANCEL;
        setSize(600,200);

        // prevent user from closing window
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        // instantiate and display two text fields
        txtName = new JTextField("Chevy",30);
        txtDate = new JTextField(15);
        txtTurbo = new JTextField("False",15);
        txtTrimPackage = new JTextField("LT",15);
        txtCost = new JTextField("10100.00", 15);

        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter= new SimpleDateFormat("MM/dd/yyyy"); //format it as per your requirement
        String dateNow = formatter.format(currentDate.getTime());
        txtDate.setText(dateNow);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(7,2));

        textPanel.add(new JLabel(""));
        textPanel.add(new JLabel("NO Erroring Checking is needed or done."));
        textPanel.add(new JLabel(""));
        textPanel.add(new JLabel(""));

        textPanel.add(new JLabel("Name of Car: "));
        textPanel.add(txtName);
        textPanel.add(new JLabel("Bought on Date: "));
        textPanel.add(txtDate);
        textPanel.add(new JLabel("Trim Package:"));
        textPanel.add(txtTrimPackage);
        textPanel.add(new JLabel("Turbo:"));
        textPanel.add(txtTurbo);
        textPanel.add(new JLabel("Amount Paid:"));
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

    /**************************************************************
     Respond to either button clicks
     @param e the action event that was just fired
     **************************************************************/
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();

        // if OK clicked the fill the object
        if (button == okButton) {
            // save the information in the object
            closeStatus = OK;
            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            GregorianCalendar temp = new GregorianCalendar();

            Date d = null;
            try {
                d = df.parse(txtDate.getText());
                temp.setTime(d);

            } catch (ParseException e1) {
//                  Do some thing good, what I am not sure.
            }
            car.setBoughtOn(temp);
            car.setAutoName(txtName.getText());
            car.setTrim(txtTrimPackage.getText());
            car.setBoughtPrice(Double.parseDouble(txtCost.getText()));

            if (txtTurbo.getText().equalsIgnoreCase("true"))
                car.setTurbo(true);
            else
                car.setTurbo(false);
        }

        // make the dialog disappear
        dispose();
    }

    /**************************************************************
     Return a String to let the caller know which button
     was clicked

     @return an int representing the option OK or CANCEL
     **************************************************************/
    public int getCloseStatus(){
        return closeStatus;
    }
}

