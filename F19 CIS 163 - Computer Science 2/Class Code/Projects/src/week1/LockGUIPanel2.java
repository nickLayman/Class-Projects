package week1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LockGUIPanel2 extends JPanel {

	private JButton[] buttons;
	private Lock lock;

	//	private JButton button0;
	//	private JButton button1;
	//	private JButton button2;
	//	private JButton button3;
	//	private JButton button4;
	//	private JButton button5;
	//	private JButton button6;
	//	private JButton button7;
	//	private JButton button8;
	//	private JButton button9;	
	//	
	private String s;
	private JLabel label;

	public LockGUIPanel2() {

		label = new JLabel ("Locked!!!");
		lock = new Lock ("234");
		s = "";

		buttons = new JButton[10];
		ButtonListener listen = new ButtonListener();

		setLayout (new GridLayout(4,3));
		
		add (label);
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton ("Button" + i);
			buttons[i].addActionListener(listen);
			add(buttons[i]);
		}

		

		//		button0 = new JButton ("Button0");
		//		button1 = new JButton ("Button1");
		//		button2 = new JButton ("Button2");
		//		button3 = new JButton ("Button3");
		//		button4 = new JButton ("Button4");
		//		button5 = new JButton ("Button5");
		//		button6 = new JButton ("Button6");
		//		button7 = new JButton ("Button7");
		//		button8 = new JButton ("Button8");
		//		button9 = new JButton ("Button9");



		//		button0.addActionListener(listen);
		//		button1.addActionListener(listen);
		//		button2.addActionListener(listen);
		//		button3.addActionListener(listen);
		//		button4.addActionListener(listen);
		//		button5.addActionListener(listen);
		//		button6.addActionListener(listen);
		//		button7.addActionListener(listen);
		//		button8.addActionListener(listen);
		//		button9.addActionListener(listen);

		//		add (button0);
		//		add (button1);
		//		add (button2);
		//		add (button3);
		//		add (button4);
		//		add (button5);
		//		add (button6);
		//		add (button7);
		//		add (button8);
		//		add (button9);

	
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			for (int i = 0; i < buttons.length; i++) {
				if (arg0.getSource() == buttons[i])
					s = s + i;
			}

			lock.enterCode(s);
			if (lock.isUnlock()) {
				label.setText("Unlocked!!!");
			}
		}
	}




}
