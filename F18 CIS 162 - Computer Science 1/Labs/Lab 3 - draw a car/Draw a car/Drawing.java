import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class Drawing here.
 *
 * @author (Nick Layman)
 * @version (9/11/2018)
 */

public class Drawing extends JPanel{
    public static void main(String[] a) {
        JFrame f = new JFrame();
        f.setContentPane(new Drawing());
        f.setSize(600, 400);
        f.setVisible(true);
    }
    int carOneTop = 50;
    int carOneLeft = 0;
    int carTwoTop = 150;
    int carTwoLeft = 400;
    public void paintComponent(Graphics g){


        // this statement required
        super.paintComponent(g);

        // optional: paint the background color (default is white)
        setBackground(Color.CYAN);

        // draw a road
        g.setColor(Color.gray);
        g.fillRect(0, 250, 1500, 150);   

        // draw dotted white lane dividers
        g.setColor(Color.white);
        g.fillRect(0, 320, 50, 20); 
        g.fillRect(75, 320, 50, 20); 
        g.fillRect(150, 320, 50, 20); 
        g.fillRect(225, 320, 50, 20); 
        g.fillRect(300, 320, 50, 20); 
        g.fillRect(375, 320, 50, 20); 
        g.fillRect(450, 320, 50, 20); 
        g.fillRect(525, 320, 50, 20); 
        g.fillRect(600, 320, 50, 20); 
        g.fillRect(675, 320, 50, 20); 
        g.fillRect(750, 320, 50, 20); 
        g.fillRect(825, 320, 50, 20); 
        g.fillRect(900, 320, 50, 20); 
        g.fillRect(975, 320, 50, 20); 
        g.fillRect(1050, 320, 50, 20); 
        g.fillRect(1125, 320, 50, 20); 
        g.fillRect(1200, 320, 50, 20); 
        g.fillRect(1275, 320, 50, 20); 
        g.fillRect(1350, 320, 50, 20); 
        g.fillRect(1425, 320, 50, 20); 

        // draw car 1 frame
        g.setColor(Color.red);
        g.fillRect(carOneLeft, carOneTop + 80, 375, 100);
        g.fillRect(carOneLeft + 100, carOneTop, 175, 80);

        // draw car 1 wheels
        g.setColor(Color.black);
        g.fillOval(carOneLeft + 50, carOneTop + 150, 75, 75);  
        g.fillOval(carOneLeft + 250, carOneTop + 150, 75, 75);  

        // draw car 2 frame
        g.setColor(Color.green);
        g.fillRect(carTwoLeft, carTwoTop + 80, 375, 100);
        g.fillRect(carTwoLeft + 100, carTwoTop, 175, 80);

        // draw car 2 wheels
        g.setColor(Color.black);
        g.fillOval(carTwoLeft + 50, carTwoTop + 150, 75, 75);  
        g.fillOval(carTwoLeft + 250, carTwoTop + 150, 75, 75); 

        // car 1 moving
        carOneLeft = (carOneLeft + 5) % 1000;
    }
}
