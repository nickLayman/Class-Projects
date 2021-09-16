package project1;

import javax.swing.*;

public class TimerPanels extends JPanel {
    public int numPanels;
    public MyTimerPanel[] panels;

    public TimerPanels(){
        numPanels = Integer.parseInt(JOptionPane.showInputDialog("How many timers?"));
        panels = new MyTimerPanel[numPanels];

        for (int i = 0; i < numPanels; i++) {
            panels[i] = new MyTimerPanel();
            add (panels[i]);
        }
    }
}
