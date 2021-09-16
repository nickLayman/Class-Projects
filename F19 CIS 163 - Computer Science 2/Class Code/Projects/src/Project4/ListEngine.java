package Project4;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class ListEngine extends AbstractListModel {

	private MySingleLinkedList listAutos;
	private MySecondLinkedList undoList;

	public ListEngine() {
		super();
		listAutos = new MySingleLinkedList ();
		undoList = new MySecondLinkedList();
		createList();
	}

	public Auto remove(int i) {
		Auto unit = listAutos.remove(i);
		fireIntervalRemoved(this, 0, listAutos.size());
		return unit;
	}

	public void add (Auto a) {
		listAutos.add(a);
		fireIntervalAdded(this, 0, listAutos.size());
	}

	public Auto get (int i) {
		return listAutos.get(i);
	}

	public Object getElementAt(int arg0) {
		Auto unit = listAutos.get(arg0);
		return unit.toString();
	}

	public int getSize() {
		return listAutos.size();
	}

	public void saveDatabase(String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(listAutos);
			os.close();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null,"Error in saving db");

		}
	}

	public void deleteList(){
		for (int i = 0; i < listAutos.size(); i++)
			undoList.addU(listAutos.get(i), 2);
	}

	public void makeUndoList(){
		for(int i = 0; i < listAutos.size(); i++)
			undoList.addU(listAutos.get(i), 3);
	}

	public void loadDatabase(String filename) {
		deleteList();
		try {
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream is = new ObjectInputStream(fis);

			listAutos = (MySingleLinkedList) is.readObject();
			fireIntervalAdded(this, 0, listAutos.size() - 1);
			is.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null,"Error in loading db");
		}
		makeUndoList();
		System.out.println("");
	}

	public void undo(){
		if (undoList.getTop() == null)
			return;

		int ROA = undoList.getROA();
		Auto s = undoList.undo();
		if (ROA == 1){
			listAutos.remove(s);
		}
		if (ROA == 0){
			listAutos.add(s);
		}
		while (ROA == 3 && listAutos.size() > 0) {
			listAutos.remove(s);
			ROA = undoList.getROA();
			s = undoList.undo();
		}
		while (ROA == 2){
			listAutos.add(s);
			ROA = undoList.getROA();
			s = undoList.undo();
		}
		fireIntervalAdded(this, 0, listAutos.size());
		fireIntervalRemoved(this, 0, listAutos.size());
	}

	public void addTo2ndLinked(Auto s, int ROA){
		undoList.addU(s, ROA);
	}

	public void createList() {

		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		GregorianCalendar temp1 = new GregorianCalendar();
		GregorianCalendar temp2 = new GregorianCalendar();
		GregorianCalendar temp3 = new GregorianCalendar();
		GregorianCalendar temp4 = new GregorianCalendar();
		GregorianCalendar temp5 = new GregorianCalendar();
		GregorianCalendar temp6 = new GregorianCalendar();

		try {
			Date d1 = df.parse("3/20/2019");
			temp1.setTime(d1);
			Date d2 = df.parse("4/20/2019");
			temp2.setTime(d2);
			Date d3 = df.parse("12/20/2018");
			temp3.setTime(d3);
			Date d4 = df.parse("1/20/2019");
			temp4.setTime(d4);
			Date d5 = df.parse("1/20/2010");
			temp5.setTime(d5);
			Date d6 = df.parse("1/20/2020");
			temp6.setTime(d6);


			Car Car1 = new Car(temp1, "Outback", 18000,"LX", false);
			Car Car2 = new Car(temp2, "Chevy", 11000,"EX", false);
			Car Car3 = new Car(temp3, "Focus", 19000,"EX", true);
			Truck Truck1 = new Truck(temp4,"F150",12000,"LX",false);
			Truck Truck2 = new Truck(temp5,"F250",42000,"LX",false);
			Truck Truck3 = new Truck(temp1,"F350",2000,"EX",true);

			add(Car1);
			add(Car2);
			add(Car3);
			add(Truck1);
			add(Truck2);
			add(Truck3);

			addTo2ndLinked(Car1, 1);
			addTo2ndLinked(Car2, 1);
			addTo2ndLinked(Car3, 1);
			addTo2ndLinked(Truck1, 1);
			addTo2ndLinked(Truck2, 1);
			addTo2ndLinked(Truck3, 1);

		} catch (ParseException e) {
			throw new RuntimeException("Error in testing, creation of list");
		}

	}
}
