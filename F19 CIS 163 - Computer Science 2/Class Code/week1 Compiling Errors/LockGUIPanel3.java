package week1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LockGUIPanel3 extends JPanel {	

	private Lock myLock;
	private JPanel panel;

	private static final int ROWSIZE = 4;
	private static final int COLSIZE = 4;

	private NumberTile buttons[][];
	String userInput = "";

	public LockGUIPanel3() {
		myLock = new Lock("345");

		ButtonListener listener = new ButtonListener();
		buttons = new NumberTile[ROWSIZE][COLSIZE];
		setLayout(new GridLayout(buttons.length,buttons[0].length,6,6));

		for (int r = 0; r < buttons.length; r++) 
			for (int c = 0; c < buttons[0].length; c++) {
//				buttons[r][c] = 
//						new NumberTile (""+ (r * buttons[0].length + c));
				buttons[r][c] = new NumberTile ("3",JLabel.CENTER);
				add(buttons[r][c]);
				//buttons[r][c].setEnabled(false);
		//		buttons[r][c].setForeground(Color.RED);
				//buttons[r][c].addActionListener(listener);
			}
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {			
			for (int r = 0; r < buttons.length; r++) 
				for (int c = 0; c < buttons[0].length; c++) {
					if (arg0.getSource() == buttons[r][c]) {
						userInput += buttons[r][c].getText();
					}
						
				}
			myLock.enterCode(userInput);
			if (myLock.isUnlock())
				buttons[3][3].setText("Unlock");
		}
	}
}
