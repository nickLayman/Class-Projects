package week1;

import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.Timer;

public class Lock {

	public  String userEnteredCode;

	private String correctCode;

	private static String masterCode = "999";

	public Lock () {
		correctCode = "123";
		userEnteredCode = "";
	}

	public Lock (String code) {
		if (code.length() == 0) {
			throw new IllegalArgumentException();
		}
		correctCode = code;
		userEnteredCode = "";
	}

	public void enterCode (String userEnterCode) {
		this.userEnteredCode = userEnterCode;
	}

	public boolean isUnlock() {	  
		if ((correctCode.equals (userEnteredCode))  ||
				(userEnteredCode.equals(masterCode)))
			return true;
		else
			return false;
	}

	public boolean equals (Lock other) {
		if (other.correctCode.equals(this.correctCode))
			return true;
		else 
			return false;
	}

	public boolean equals (Object other) {
		if (other != null) {
			if (other instanceof Lock) {
				Lock temp = (Lock) other;
				if (temp.correctCode.equals(this.correctCode))
					return true;
				else 
					return false;
			}
		}
		return false;
	}

	public static boolean equals (Lock s1, Lock s2) {
		if (s1.correctCode.equals(s2.correctCode))
			return true;
		else 
			return false;


	}

	public void load(String fileName) {
		try{

			// open the data file
			Scanner fileReader = new Scanner(new File(fileName)); 

			// read one int
			correctCode = fileReader.next();
			userEnteredCode = fileReader.next();

			System.out.println (correctCode);
			System.out.println (userEnteredCode);
		}

		// problem reading the file
		catch(Exception error){
			System.out.println("Oops!  Something went wrong.");
		}

	}

	public void save(String fileName) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		out.println(correctCode);
		out.println(userEnteredCode);
		out.close(); 
	}
}
