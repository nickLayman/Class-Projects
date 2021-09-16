package project1;

import javax.swing.*;

public class MyTimer {

    public static void main(String[] args) {

        JFrame frame = new JFrame("GEO Count Down Timer!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TimerPanels panel = new TimerPanels();
        frame.getContentPane().add(panel);

        frame.setSize(850, 500);
        frame.setVisible(true);
    }

}
