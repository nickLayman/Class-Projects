package project3;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/************************************************************************
 * This program builds a GUI that works as a car/truck registry.
 * Multiple functions are used to allow the user to buy, sell, and view
 * their inventory
 *
 * @author Justin Von Kulajta Winn and Nick Layman
 * @version 1.8
 ************************************************************************/
public class ListEngine extends AbstractTableModel {

    /** this is Array List that holds all of the autos in the inventory */
    private ArrayList<Auto> listAutos;

    /** this is the Array List that holds all of the autos displayed on the GUI */
    private ArrayList<Auto> filteredListAutos;

    /** this is the array for the column names in the bought screen */
    private String[] columnNamesBought = {"Auto Name", "Bought Cost",
            "Bought Date", "Trim Package ", "Four by Four", "Turbo"};

    /** this is the array for the column names in the sold screen */
    private String[] columnNamesSold = {"Auto Name", "Bought Cost",
            "Bought Date", "Buyer's Name", "Sold For", "Sold On"};

    /** this is the array for the column names in the overdue screen */
    private String[] columnNamesOverdue = {"Auto Name", "Bought Cost",
            "Bought Date", "Days Overdue"};

    /** this is the variable representing the bought screen */
    public final int boughtScreen = 0;

    /** this is the variable representing the sold screen */
    public final int soldScreen = 1;

    /** this is the variable representing the overdue screen */
    public final int overdueScreen = 2;

    /** this is the variable representing the current display screen */
    public int displayValue;

    /** this is the variable representing the date format used throughout the code */
    SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    /************************************************************************
     * This is a function that overrides the abstract function is the super
     * class. It returns the name of whatever screen is being displayed.
     * @param col is the column number sent to the function
     * @return the name of the column of whatever screen is being displayed
     ************************************************************************/
    @Override
    public String getColumnName(int col) {
        switch(displayValue){
            case boughtScreen:
                return columnNamesBought[col];

            case soldScreen:
                return columnNamesSold[col];

            case overdueScreen:
                return columnNamesOverdue[col];

            default:
                throw new RuntimeException("JTable col out of range: " + col);
        }
    }

    /************************************************************************
     * This is the constructor of the class. It creates an the arrayList
     * 'listAutos' and the calls a function to add to the list. It then
     * updates the display to sort the vehicles.
     ************************************************************************/
    public ListEngine() {
        super();
        listAutos = new ArrayList<Auto>();
        createList();
        updateDisplay(0);
    }

    /************************************************************************
     * This function updates the display to choose which screen is to be
     * displayed. It then sorts the arrayList appropriately.
     * @param pDisplayValue is the value of the screen that is to be displayed
     ************************************************************************/
    public void updateDisplay(int pDisplayValue){
        displayValue = pDisplayValue;

        if (displayValue == boughtScreen) {
            filteredListAutos = (ArrayList<Auto>) listAutos.stream()
                    .filter(arg -> arg.getSoldOn() == null)
                    .collect(Collectors.toList());
            Collections.sort(filteredListAutos, ((auto1, auto2) ->
                    auto1.getBoughtOn().compareTo(auto2.getBoughtOn())));
        }
        else if (displayValue == soldScreen) {
            filteredListAutos = (ArrayList<Auto>) listAutos.stream()
                    .filter(arg -> arg.getSoldOn() != null)
                    .collect(Collectors.toList());
            Collections.sort(filteredListAutos, new Comparator<Auto>() {
                @Override
                public int compare(Auto auto1, Auto auto2) {
                    return auto1.getNameOfBuyer().compareTo(auto2.getNameOfBuyer());
                }
            });
        }
        else if (displayValue == overdueScreen)
            filteredListAutos = (ArrayList<Auto>)listAutos.stream()
                    .filter(arg -> arg.getSoldOn() == null
                            && arg.getDaysOverdue() >= 30)
                    .sorted(Comparator.comparing(Auto::getDaysOverdue).reversed())
                    .collect(Collectors.toList());
        else
            filteredListAutos = listAutos;

        fireTableDataChanged();
        fireTableStructureChanged();
    }

    /************************************************************************
     * This function adds an auto to the arraylist that holds the cars in
     * the user's inventory
     * @param a is the auto that is to be added to the arrayList
     ************************************************************************/
    public void add(Auto a) {
        listAutos.add(a);
        Collections.sort(listAutos, Comparator.comparing(o ->
                o.getAutoName().toUpperCase()));
        fireTableDataChanged();
        updateDisplay(displayValue);
    }

    /************************************************************************
     * This function returns the the auto at location 'i' in the arrayList
     * @param i is the location in the arrayList of the desired auto
     * @return the auto at location 'i' in the arrayList
     ************************************************************************/
    public Auto get(int i) {
        return filteredListAutos.get(i);
    }

    /************************************************************************
     * This function returns the size of the arrayList
     * @return the size of the arrayList
     ************************************************************************/
    public int getSize() {
        return filteredListAutos.size();
    }

    /************************************************************************
     * This function returns how many rows are in the J Table
     * @return the number of rows in the J Table
     ************************************************************************/
    @Override
    public int getRowCount() {
        return filteredListAutos.size();
    }

    /************************************************************************
     * This function gets the number of columns in the J Table
     * @return the number of columns depending on which screen you are
     *         currently on
     ************************************************************************/
    @Override
    public int getColumnCount() {
        switch(displayValue){
            case boughtScreen:
                return columnNamesBought.length;
            case soldScreen:
                return columnNamesSold.length;
            case overdueScreen:
                return columnNamesOverdue.length;
            default:
                throw new RuntimeException("JTable Column Count Error");
        }
    }

    /************************************************************************
     * This function returns the object at a specific location using a
     * coordinate system.
     * @param col is the column number that is wanted by the user
     * @param row is the row number that is wanted by the user
     * @return the object at the desired location
     ************************************************************************/
    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case 0:
                return (filteredListAutos.get(row).getAutoName());

            case 1:
                return (filteredListAutos.get(row).getBoughtCost());

            case 2:
                return (df.format(filteredListAutos.
                        get(row).getBoughtOn().getTime()));

            case 3:
                if (displayValue == boughtScreen)
                    return (filteredListAutos.get(row).getTrim());
                else if (displayValue == soldScreen)
                    return filteredListAutos.get(row).getNameOfBuyer();
                else if (displayValue == overdueScreen)
                    return filteredListAutos.get(row).getDaysOverdue();

            case 4:
                if (displayValue == soldScreen)
                    return filteredListAutos.get(row).getSoldPrice();
            case 5:
                if (displayValue == boughtScreen) {
                    if (filteredListAutos.get(row) instanceof Truck)
                        if (col == 4)
                            return (((Truck) filteredListAutos.
                                    get(row)).isFourByFour());
                        else
                            return "";

                    else {
                        if (col == 5)
                            return (((Car) filteredListAutos.get(row)).isTurbo());
                        else
                            return "";
                    }
                }
                else if (displayValue == soldScreen)
                    return (df.format(filteredListAutos.get(row).
                            getSoldOn().getTime()));
            default:
                throw new RuntimeException("JTable row,col out of range: " +
                        row + " " + col);
        }
    }

    /************************************************************************
     * This function saves the current arrayList to a file that is non-text
     * based.
     * @param filename is the name of the file that the arrayList
     *                 is saved into
     ************************************************************************/
    public void saveDatabase(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(listAutos);
            os.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error in saving db");

        }
    }

    /************************************************************************
     * This function loads a file and uses the data from the file to build
     * the cars and trucks within the file.
     * @param filename is the name of the file that is to be read
     ************************************************************************/
    public void loadDatabase(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream is = new ObjectInputStream(fis);

            listAutos = (ArrayList<Auto>) is.readObject();
            fireTableDataChanged();
            is.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in loading db");
        }
    }

    /************************************************************************
     * This function saves the arrayList into a file. It breaks up each
     * car and truck into each of their elements. It first saves the number
     * of vehicles, then goes through the array and saves each component of
     * every car and truck.
     * @param filename is the name of the file that the data will be saved
     *                 into
     ************************************************************************/
    public boolean saveAsText(String filename) {
        String bought;

        if (filename.equals(""))
            return false;
        try {
            PrintStream out = new PrintStream(new FileOutputStream(filename));

            out.println(listAutos.size());
            for (int i = 0; i < listAutos.size(); i++){
                Auto temp = listAutos.get(i);
                out.println(temp.getClass().getName());//Truck or Car

                out.println(temp.getAutoName());
                if (temp.getBoughtOn() == null)
                    bought = "Not Bought";
                else
                    bought = df.format(temp.getBoughtOn().getTime());
                out.println(bought);

                String soldDate;
                if (temp.getSoldOn() == null)
                    soldDate = "Not Sold";
                else {
                    soldDate = df.format(temp.getSoldOn().getTime());
                }

                out.println(soldDate);//Date the Auto was sold
                String Buyer;
                if (temp.getNameOfBuyer() == null)
                    Buyer = "Not Sold";
                else {
                    Buyer = temp.getNameOfBuyer();
                }
                out.println(Buyer);
                out.println(temp.getSoldPrice());
                out.println(temp.getTrim());
                out.println(temp.getBoughtCost());
                boolean turbo;
                boolean fourBy;
                if (temp.getClass().getName().equals("project3.Truck")){
                    Truck truck1 = (Truck) temp;
                    fourBy = truck1.isFourByFour();
                    if (fourBy)
                        out.println("true");
                    else
                        out.println("false");
                }
                if (temp.getClass().getName().equals("project3.Car")){
                    Car car1 = (Car) temp;
                    turbo = car1.isTurbo();
                    if (turbo)
                        out.println("true");
                    else
                        out.println("false");
                }
            }
        }
        catch (Exception e) {
            //pop up window saying it does not work
        }
        return true;
    }

    /************************************************************************
     * This function loads every car and truck from the file. The function
     * first finds the number of vehicles and then saves all data needed for
     * creating each truck and car
     * @param filename is the name of the file that the data will be loaded
     *                 in from
     ************************************************************************/
    public void loadFromText(String filename) {
        listAutos.clear();
        try {
            if (filename == null) {
                // hopefully unreachable
                throw new Exception();
            }

            BufferedReader read = new BufferedReader(new FileReader(filename));

            String Auto;
            String AutoName;
            String boughtTime;
            String SoldDate;
            String Buyer;
            String SoldPrice;
            String Trim;
            String BoughtCost;
            String turboS;
            String FourByS;
            String TimeSold;

            boolean turbo;
            boolean FourBy;

            int CarNum = 0;
            int TruckNum = 0;

            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            SimpleDateFormat dc = new SimpleDateFormat("MM/dd/yyyy");
            Date d1;
            Date d2;

            String line = read.readLine();
            int length = Integer.parseInt(line);

            Car Cars[] = new Car[length];
            Truck Trucks[] = new Truck[length];

            for (int i = 0; i < length; i++) {
                Auto = read.readLine();
                AutoName = read.readLine();
                GregorianCalendar tempDate = new GregorianCalendar();
                boughtTime = read.readLine();
                if (boughtTime.equalsIgnoreCase("Not Bought"))
                    tempDate = null;
                else {
                    d1 = df.parse(boughtTime);
                    tempDate.setTime(d1);
                }
                SoldDate = read.readLine();
                GregorianCalendar tempDateSold = new GregorianCalendar();
                if (SoldDate.equalsIgnoreCase("Not Sold"))
                    tempDateSold = null;
                else{
                    d2 = dc.parse(boughtTime);
                    tempDateSold.setTime(d2);
                }
                Buyer = read.readLine();
                SoldPrice = read.readLine();
                Trim = read.readLine();
                BoughtCost = read.readLine();
                if (Auto.equals("project3.Truck")){
                    FourByS = read.readLine();
                    if (FourByS.equalsIgnoreCase("true"))
                        FourBy = true;
                    else
                        FourBy = false;
                    Trucks[TruckNum] =
                            new Truck(tempDate, AutoName, Buyer, Trim, FourBy);
                    ((Auto) Trucks[TruckNum]).
                            setBoughtCost(Double.parseDouble(BoughtCost));
                    ((Auto) Trucks[TruckNum]).
                            setSoldPrice(Double.parseDouble(SoldPrice));
                    ((Auto) Trucks[TruckNum]).setSoldOn(tempDateSold);
                    TruckNum++;

                }
                if (Auto.equals("project3.Car")){
                    turboS = read.readLine();
                    if (turboS.equalsIgnoreCase("true"))
                        turbo = true;
                    else
                        turbo = false;
                    Cars[CarNum] = new Car(tempDate, AutoName, Buyer, Trim, turbo);
                    ((Auto) Cars[CarNum]).
                            setBoughtCost(Double.parseDouble(BoughtCost));
                    ((Auto) Cars[CarNum]).
                            setSoldPrice(Double.parseDouble(SoldPrice));
                    ((Auto) Cars[CarNum]).setSoldOn(tempDateSold);
                    CarNum++;
                }
            }
            for (int j = 0; j < TruckNum; j++)
                add(Trucks[j]);
            for (int k = 0; k < CarNum; k++)
                add(Cars[k]);
            updateDisplay(displayValue);
        }
        catch (Exception e){
            //throw something here
        }
    }

    /************************************************************************
     * This function creates a starting list that starts the display with
     * 6 vehicles. 3 cars and 3 trucks are created.
     ************************************************************************/
    public void createList() {

        // This code has been provided to get you started on the project.

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
            Date d2 = df.parse("9/20/2019");
            temp2.setTime(d2);
            Date d3 = df.parse("12/20/2018");
            temp3.setTime(d3);
            Date d4 = df.parse("9/20/2019");
            temp4.setTime(d4);
            Date d5 = df.parse("1/20/2010");
            temp5.setTime(d5);
            Date d6 = df.parse("10/20/2019");
            temp6.setTime(d6);


            Car Car1 = new Car(temp3, "Outback", "Buyer1", "LX", false);
            Car Car2 = new Car(temp2, "Chevy", "Buyer2", "EX", false);
            Car Car3 = new Car(temp6, "Focus", "Buyer3", "EX", true);
            Truck Truck1 = new Truck(temp4, "F150", "BuyerA", "LX", false);
            Truck Truck2 = new Truck(temp1, "F250", "BuyerB", "LX", false);
            Truck Truck3 = new Truck(temp5, "F350", "BuyerC", "EX", true);

            add(Car1);
            add(Car2);
            add(Car3);
            add(Truck1);
            add(Truck2);
            add(Truck3);
        } catch (ParseException e) {
            throw new RuntimeException("Error in testing, creation of list");
        }

    }

/*

   Here is the instructor's test data.  This will be the starting point for project
   demonstration day.


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
            Date d2 = df.parse("9/20/2019");
            temp2.setTime(d2);
            Date d3 = df.parse("12/20/2018");
            temp3.setTime(d3);
            Date d4 = df.parse("9/20/2019");
            temp4.setTime(d4);
            Date d5 = df.parse("1/20/2010");
            temp5.setTime(d5);
            Date d6 = df.parse("10/20/2019");
            temp6.setTime(d6);


            Car Car1 = new Car (temp1, "Outback", 18000,"LX", false);
            Car Car2 = new Car (temp2, "Chevy", 11000,"EX", false);
            Car Car3 = new Car (temp3, "Focus", 19000,"EX", true);
            Truck Truck1 = new Truck(temp4,"F150",12000,"Tow",false);
            Truck Truck2 = new Truck(temp5,"F250",42000,"NA",false);
            Truck Truck3 = new Truck(temp1,"F350",2000,"Turbo",true);

            add(Car1);
            add(Car2);
            add(Car3);
            add(Truck1);
            add(Truck2);
            add(Truck3);


        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error in creating inventory");
            exit(-1);
        }

    }

 */
}