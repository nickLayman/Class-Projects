package project1;

/*

Once your GeoCountDownTimer class is functioning un-comment this code.


 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyTimerPanel extends JPanel{
    private GeoCountDownTimer geoCountDownTimer;
    private GeoCountDownTimer geoCountDownTimer2;

    private Timer javaTimer;
    private TimerListener timer;
    private JLabel currDate, end, daysLeft;
    private JButton start, stop, load, save, enter, changeBy;
    private JTextField dateInput;

    public MyTimerPanel() {
        geoCountDownTimer = new GeoCountDownTimer();
        geoCountDownTimer2 = new GeoCountDownTimer();
        timer = new TimerListener();
        currDate = new JLabel("Today: " + geoCountDownTimer2.toDateString());
        end = new JLabel("| End: " + geoCountDownTimer.toDateString());
        daysLeft = new JLabel("| " + geoCountDownTimer.daysToGo(geoCountDownTimer2.toDateString()) + " days left");

        start = new JButton("start");
        stop = new JButton("stop");
        changeBy = new JButton("change by");
        load = new JButton("load");
        save = new JButton("save");
        enter = new JButton("enter");
        dateInput = new JTextField(11);


        add (currDate);
        add (end);
        add (daysLeft);
        add (start);
        add (stop);
        add (changeBy);
        add (load);
        add (save);
        add (enter);
        add (dateInput);

        start.addActionListener(new ButListener());
        stop.addActionListener(new ButListener());
        changeBy.addActionListener(new ButListener());
        load.addActionListener(new ButListener());
        save.addActionListener(new ButListener());
        enter.addActionListener(new ButListener());

// this calls timer object 10 times per second
        javaTimer = new Timer(1, timer);

// There is a problem here, your demonstration of your program could take years.  So, you can
// assume that every time the timer object is called equals one day.  So, in about 3 seconds would be
// a month.   That is how you can speed up time.

        //javaTimer.start();
    }

    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (geoCountDownTimer.compareTo(geoCountDownTimer2) <= 0) {
                System.out.println ("Time is up!");
                javaTimer.stop();
            } else {
                geoCountDownTimer2.inc();
                currDate.setText("Today: " + geoCountDownTimer2.toDateString());
                daysLeft.setText("| " + geoCountDownTimer.daysToGo(geoCountDownTimer2.toDateString()) + " days left");
            }
        }
    }

    private class ButListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == start)
                javaTimer.start();

            if (e.getSource() == stop)
                javaTimer.stop();

            if (e.getSource() == changeBy) {
                try {
                    geoCountDownTimer = geoCountDownTimer.daysInFuture(Integer.parseInt(JOptionPane.showInputDialog("change by how many days?")));
                } catch (Exception error){
                    throw new IllegalArgumentException();
                }
                end.setText("| End: " + geoCountDownTimer.toDateString());
                daysLeft.setText("| " + geoCountDownTimer.daysToGo(geoCountDownTimer2.toDateString()) + " days left");
            }

            if (e.getSource() == load) {
                javaTimer.stop();
                geoCountDownTimer.load(JOptionPane.showInputDialog("File name?", geoCountDownTimer.toString()));
                end.setText("| End: " + geoCountDownTimer.toDateString());
                daysLeft.setText("| " + geoCountDownTimer.daysToGo(geoCountDownTimer2.toDateString()) + " days left");
            }

            if (e.getSource() == save)
                geoCountDownTimer.save(JOptionPane.showInputDialog("File name?", geoCountDownTimer.toString()));

            if (e.getSource() == enter) {
                javaTimer.stop();
                geoCountDownTimer = new GeoCountDownTimer(dateInput.getText());
                end.setText("| End: " + geoCountDownTimer.toDateString());
                daysLeft.setText("| " + geoCountDownTimer.daysToGo(geoCountDownTimer2.toDateString()) + " days left");
            }
        }

    }

}

	
	
