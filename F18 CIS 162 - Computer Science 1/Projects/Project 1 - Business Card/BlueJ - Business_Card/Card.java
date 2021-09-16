import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
/**
 * Making a business card.
 *
 * @author (Nick Layman)
 * @version (9/14/2018)
 */

public class Card extends JPanel{
    public static void main(String[] a) {
        JFrame f = new JFrame();
        f.setContentPane(new Card());
        f.setSize(550, 385);
        f.setVisible(true);
    }
    
    public void paintComponent(Graphics g){
        int outlinex = 10;             // left of card outline
        int outliney = 10;             // top of card outline
        int namex = outlinex + 285;    // left of name
        int namey = outliney + 75;     // bottom of name
        int jobNamex = namex;          // left of job name
        int jobNamey = namey + 50;     // bottom of job name
        int mottox = outlinex + 80;    // left of motto
        int mottoy = outliney + 210;   // bottom of motto
        int phonex = mottox + 45;      // left of phone
        int phoney = mottoy + 35;      // bottom of phone
        int emailx = phonex - 22;      // left of email
        int emaily = phoney + 30;      // bottom of email
        int logox = 155;               // left of logo
        int logoy = 40;                // top of logo
        int picturex = 20;             // left of picture
        int picturey = 30;             // top of picture
        
        // define all used fonts
        Font nameFont = new Font("serif", Font.PLAIN, 35);
        Font companyFont = new Font("serif", Font.PLAIN, 25);
        Font mottoFont = new Font("serif", Font.PLAIN, 25);
        Font mottoFontPun = new Font("serif", Font.ITALIC, 25);
        Font contactFont = new Font("serif", Font.PLAIN, 20);
        Font coinFont1 = new Font ("serif", Font.PLAIN, 15);
        Font coinFont2 = new Font ("serif", Font.PLAIN, 25);
        
        // this statement required
        super.paintComponent(g);
        
        // draw card outline
        g.setColor(Color.white);
        g.fillRect(outlinex, outliney, 500, 300);
        g.setColor(Color.black);
        g.drawRect(outlinex, outliney, 500, 300);
        
        // display my name
        g.setColor(Color.black);
        g.setFont(nameFont);
        g.drawString("Nick Layman", namex, namey);
        
        // display company name
        g.setColor(Color.black);
        g.setFont(companyFont);
        g.drawString("Financial Advisor", jobNamex, jobNamey);
        
        // display my motto and pun
        g.setColor(Color.gray);
        g.setFont(mottoFont);
        g.drawString("\"I won't", mottox, mottoy);
        g.setFont(mottoFontPun);
        g.drawString("Nick", mottox + 85, mottoy);
        g.setFont(mottoFont);
        g.drawString("-el and dime you\"", mottox + 137, mottoy);
        
        // display contact information
        g.setColor(Color.red);
        g.setFont(contactFont);
        g.drawString("Phone: ", phonex, phoney);
        g.setColor(Color.black);
        g.drawString("(708) - 955 - 7275", phonex + 59, phoney);
        g.setColor(Color.red);
        g.drawString("Email: ", emailx, emaily);
        g.setColor(Color.black);
        g.drawString("laymann@mail.gvsu.edu", emailx + 58, emaily);
        
        // define logo letter coordinates
        int[] letternx = 
        {logox, logox, logox + 20, logox + 50, 
         logox + 50, logox + 65, logox + 65, logox + 50, 
         logox + 20, logox + 20, logox};
        int[] letterny = 
        {logoy + 120, logoy, logoy, logoy + 60, 
         logoy, logoy, logoy + 120, logoy + 120, 
         logoy + 60, logoy + 120, logoy + 120};
        int[] letterlx = 
        {logox + 65, logox + 80, logox + 80, logox + 115, 
         logox + 115, logox + 65, logox + 65};
        int[] letterly = 
        {logoy, logoy, logoy + 90, logoy + 90, 
         logoy + 120, logoy + 120, logoy};
         
        // display NL of logo
        g.setColor(Color.red);
        g.fillPolygon(letternx, letterny, 11);
        g.setColor(Color.blue);
        g.fillPolygon(letterlx, letterly, 7);
        
        // display coins of logo
        g.setColor(Color.lightGray);
        g.fillOval(logox + 30, logoy + 9, 20, 20);
        g.fillOval(logox + 80, logoy + 60, 30, 30);
        g.fillOval(logox + 80, logoy + 30, 30, 30);
        g.fillOval(logox + 80, logoy, 30, 30);
        g.setColor(Color.black);
        g.setFont(coinFont1);
        g.drawString("¢", logox + 36, logoy + 22);
        g.setFont(coinFont2);
        g.drawString("¢", logox + 90, logoy + 20);
        g.drawString("¢", logox + 90, logoy + 50);
        g.drawString("¢", logox + 90, logoy + 80);
        
        // display picture
        BufferedImage photo = null;
        try {
            File file = new File("business picture.jpg");
            photo = ImageIO.read(file);
        } catch (IOException e){
            g.drawString("Problem reading the file", 100, 100);
        }
        g.drawImage(photo, picturex, picturey, 120, 140, null);

    }
}
