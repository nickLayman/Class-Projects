package project1;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/************************************************************************
 * This program builds a GUI date clock and counts up to a desired date.
 * Multiple functions are used to count the clock
 *
 * @author Nicholas Layman
 * @author Justin Von Kulajta Winn
 * @version 1.8
 ***********************************************************************/

public class GeoCountDownTimer {

    /** This is the number of months for a given date */
    private int month;

    /** this is the number of years for a given date */
    private int year;

    /** this is the number of days for a given date */
    private int day;

    /** this is the minimum year the count down timer can go */
    private static final int MINYEAR = 2019;

    /************************************************************************
     * This is a basic constructor and has no inputs or returns. This sets
     * the date to the earliest date possible
     ************************************************************************/
    public GeoCountDownTimer() {
        this.month = 1;
        this.day = 1;
        this.year = MINYEAR;
    }

    /************************************************************************
     * This is a constructor that sets the month, day, and year so long as
     * the given inputs make a valid date
     * @param pMonth is the month to be set as the instance variable
     * @param pDay is the day to be set as the instance variable
     * @param pYear is the year to be set as the instance variable
     * @throws IllegalArgumentException is thrown when the date is invalid
     ************************************************************************/
    public GeoCountDownTimer(int pMonth, int pDay, int pYear){
        if (!isValidDate(pMonth, pDay, pYear))
            throw new IllegalArgumentException();

        this.month = pMonth;
        this.day = pDay;
        this.year = pYear;
    }

    /************************************************************************
     * This is a constructor that sets the instance variables month, day,
     * and year to that of another, given GeoCountDownTimer
     * @param pOther is the GeoCountDownTimer being used to set the instance variables
     ************************************************************************/
    public void GeoCountDownTimer(GeoCountDownTimer pOther){
        this.month = pOther.month;
        this.day = pOther.day;
        this.year = pOther.year;
    }

    /************************************************************************
     * This is a constructor that breaks up a string and sets the instance
     * variables equal to the respective component
     * @param geoDate is the string that holds the month, day and year
     *                in the format "mm/dd/yyyy"
     * @throws IllegalArgumentException is thrown when the given date
     *                                 is invalid. It is also used when the
     *                                 string is formatted incorrectly
     ************************************************************************/
    public GeoCountDownTimer(String geoDate){
        String[] date = geoDate.split("/", 0);

        if (date.length == 3){
            this.month = Integer.parseInt(date[0]);
            this.day = Integer.parseInt(date[1]);
            this.year = Integer.parseInt(date[2]);
        } else
            throw new IllegalArgumentException();

        if (!isValidDate(this.month, this.day, this.year))
            throw new IllegalArgumentException();
    }

    /************************************************************************
     * This function checks if the GeoCountDownTimer is equal to the object
     * sent in
     * @param pOther is an object that is likely to be holding a GeoCountDownTimer
     * @throws IllegalArgumentException when the object is not holding anything
     *                                 or if the object is not a GeoCountDownTimer
     * @return true if the month, day, and year match. returns false if they do not
     ************************************************************************/
    public boolean equals(Object pOther){
        if (pOther != null) {
            if (pOther instanceof GeoCountDownTimer) {
                GeoCountDownTimer temp = (GeoCountDownTimer) pOther;
                return this.year == temp.year && this.month == temp.month
                        && this.day == temp.day;
            }
        }
        throw new IllegalArgumentException();
    }

    /************************************************************************
     *  This function compares two GeoCountDownTimer variables
     * @param other is the 2nd GeoCountDownTimer that is being compared to the
     *              instance variables
     * @return 1 if 'this' is a later date than 'other', 0 if they are the same date,
     *         and -1 if 'other' is a later date 'this'
     ************************************************************************/
    public int compareTo(GeoCountDownTimer other){
        if (this.equals(other))
            return 0;

        if (this.year < other.year)
            return -1;

        if (this.year == other.year && this.month < other.month)
            return -1;

        if (this.year == other.year && this.month == other.month && this.day < other.day)
            return -1;

        return 1;
    }

    /************************************************************************
     * This function decreases the date by 1 day
     ************************************************************************/
    public void dec(){
        this.dec(1);
    }

    /************************************************************************
     * This function increases the date by 1 day
     ************************************************************************/
    public void inc(){
        this.inc(1);
    }

    /** this is the array for days in each month */
    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31,
            31, 30, 31, 30, 31};

    /** this is the array that holds the names of each month */
    private static final String[] MONTHS = {"", "January", "February",
            "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};

    /************************************************************************
     * This function takes in a month and year and returns how many days are
     * in that month. Useful for checking leap years.
     * @param pMonth is the month being checked
     * @param pYear is the year being checked in
     * @return the number of days in the given month
     * @throws IllegalArgumentException when the month or year is out of range
     ************************************************************************/
    public static int daysInMonth(int pMonth, int pYear){
        if (pMonth < 1 || pMonth > 12)
            throw new IllegalArgumentException();

        if (!isLeapYear(pYear) || pMonth != 2)
            return DAYS_IN_MONTH[pMonth];
        else
            return 29;
    }

    /************************************************************************
     *This function takes in a month, day, and year and returns if that
     * date is a valid date, if it could ever happen
     * @param month is the given month
     * @param day is the given day
     * @param year is the given year
     * @return false if any of the values are out of range and true otherwise
     ************************************************************************/
    public static boolean isValidDate(int month, int day, int year) {
        if (month < 1 || month > 12)
            return false;

        if (day < 1 || day > daysInMonth(month, year))
            return false;

        if (year < MINYEAR)
            return false;

        return true;
    }

    /************************************************************************
     * This function determines if the current year is a leap year or not
     * @param year is the year being tested whether or not it is a leap year
     * @return true if it is a leap year, false if it is not
     ************************************************************************/
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    /************************************************************************
     * This function checks if the 2 given GeoCountDownTimers are equal
     * @param s1 is the first GeoCountDownTimer
     * @param s2 is the second GeoCountDownTimer
     * @return true if the month, day, and year are each equal and false otherwise
     * @throws IllegalArgumentException if either object is null or is not
     *                                  a GeoCountDownTimer
     ************************************************************************/
    public static boolean equals(Object s1, Object s2) {
        if (s1 != null && s2 != null) {
            if (s1 instanceof GeoCountDownTimer && s2 instanceof GeoCountDownTimer) {
                GeoCountDownTimer temp1 = (GeoCountDownTimer) s1;
                GeoCountDownTimer temp2 = (GeoCountDownTimer) s2;
                return temp1.year == temp2.year && temp1.month == temp2.month
                        && temp1.day == temp2.day;
            }
        }
        throw new IllegalArgumentException();
    }

    /************************************************************************
     * This function returns a string of the date in the form "Month_name day, year"
     * @return the string holding the month, day, and year in the proper form
     ************************************************************************/
    public String toString() {
        return MONTHS[this.month] + " " + this.day + ", " + this.year;
    }

    /************************************************************************
     * This function returns a string of the date in the form month/day/year
     * @return a string holding the month, day and year in the specified form
     ************************************************************************/
    public String toDateString(){
        return this.month + "/" + this.day + "/" + this.year;
    }

    /************************************************************************
     * This function decreases the date by pDays
     * @param pDays is the number of days the date is being decreased by
     * @throws IllegalArgumentException when pDays is negative or the year falls
     *                                 below the MINYEAR
     ************************************************************************/
    public void dec(int pDays) {
        if (pDays < 0)
            throw new IllegalArgumentException();

        this.day -= pDays;

        // keep adding the number of days in the month while moving the
        // month back until day is positive
        while (this.day < 1){
            this.month -= 1;

            if (this.month < 1){
                this.month += 12;
                this.year -= 1;
            }

            this.day += daysInMonth(this.month, this.year);

            if (this.year < MINYEAR){
                throw new IllegalArgumentException();
            }
        }
    }

    /************************************************************************
     *This function increases the date by pDays
     * @param pDays is the number of days the date is being increased by
     * @throws IllegalArgumentException when pDays is negative
     ************************************************************************/
    public void inc(int pDays) {
        if (pDays < 0)
            throw new IllegalArgumentException();

        this.day += pDays;

        // keep subtracting the number of days in the month off while moving
        // the month forward until day is a valid number
        while (this.day > daysInMonth(this.month, this.year)){
            this.day -= daysInMonth(this.month, this.year);
            this.month += 1;

            if (this.month > 12){
                this.month -= 12;
                this.year += 1;
            }
        }
    }

    /************************************************************************
     * This function saves the current date in the given file name
     * @param filename is the name of the file the data is being saved into
     * @throws IllegalArgumentException if filename is invalid
     ************************************************************************/
    public void save(String filename) {

        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

        out.println (month);
        out.println (day);
        out.println (year);

        out.close();
    }

    /************************************************************************
     * This function pulls up the saved month, day, and year and sets 'this'
     * equal to them
     * @param filename is the name of the file the date is being pulled from
     * @throws IllegalArgumentException if the file does not exist or if its
     *                                  contents are not in the necessary format
     ************************************************************************/
    public void load(String filename){
        try{
            Scanner fileReader = new Scanner(new File(filename));

            this.month = fileReader.nextInt();
            this.day = fileReader.nextInt();
            this.year = fileReader.nextInt();
        } catch (Exception error) {
            throw new IllegalArgumentException();
        }
    }

    /************************************************************************
     * This function finds the number of days to go until timer reaches 0
     * @param fromDate is the string holding the desired date to check from.
     *                 This would normally be today.
     * @return the numbers of days between the two dates
     * @throws IllegalArgumentException if the date passed is later than 'this'
     ************************************************************************/
    public int daysToGo(String fromDate){
        GeoCountDownTimer temp = new GeoCountDownTimer(fromDate);

        if (this.compareTo(temp) < 0)
            throw new IllegalArgumentException();

        int daysToGo = 0;

        // keep moving the fromdate timer forward by 1 until
        // the other timer is reached
        while (this.compareTo(temp) > 0){
            daysToGo += 1;
            temp.inc();
        }

        return daysToGo;
    }

    /************************************************************************
     * This date finds the date which is n days from 'this'.
     * @param n is the number of days the found date should be from 'this'
     *          can be positive or negative
     * @return GeoCountDownTimer temp which is the future/past date found
     ************************************************************************/
    public GeoCountDownTimer daysInFuture(int n){
        GeoCountDownTimer temp = new GeoCountDownTimer(this.toDateString());

        if (n > 0)
            temp.inc(n);
        else
            temp.dec(-n);

        return temp;
    }

    /************************************************************************
     * This is the main function where tests are being run
     ************************************************************************/
    public static void main() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/10/2020");
        System.out.println("Date: " + s);

        GeoCountDownTimer s1 = new GeoCountDownTimer("2/10/2022");
        System.out.println("Date: " + s1.toString());

        s1.dec(365);
        System.out.println("Date: " + s1);

        GeoCountDownTimer s2 = new GeoCountDownTimer("2/10/2019");
        for (int i = 0; i < (365 + 366); i++)
            s2.inc(1);
        System.out.println("Date: " + s2);


        GeoCountDownTimer s3 =  new GeoCountDownTimer(5, 5, 2019);
        s3.dec(700);
        System.out.println("Date: " + s3);

        s3.inc(1000);
        System.out.println("Date: " + s3.toDateString());

        GeoCountDownTimer s4 = new GeoCountDownTimer("11/7/2019");
        GeoCountDownTimer s5 = new GeoCountDownTimer();
        s5.GeoCountDownTimer(s4);

        try{
            s4.dec(3660);
            s5.dec(3660);
            System.out.println("FAILED");
        } catch (IllegalArgumentException e){
            System.out.println("Date: " + s4.toDateString());
            System.out.println("Date: " + s5.toDateString());
        }


        System.out.println("Comparison Tests");
        System.out.println("If the first timer is greater than the other timer, then the test");
        System.out.println("returns a 1");
        System.out.println("If the two timers are equal, the test will return a 0");
        System.out.println("If the second timer is greater than the first, then the test");
        System.out.println("returns a -1");
        System.out.println("Comparison Value: " + s4.compareTo(s5));

        System.out.println("Save/Load Test");
        GeoCountDownTimer s6 = new GeoCountDownTimer("1/1/2018");

        s6.inc();
        s6.save("temp.txt");

        s6.load("temp.txt");

        System.out.println("Loaded Date: "+ s6);

        System.out.println("Days To Go Test!");

        System.out.println("Days between s6 and '12/12/2017:' " + s6.daysToGo("12/12/2017"));

        System.out.println("Days in the Future Test");

        GeoCountDownTimer s7 = new GeoCountDownTimer();
        s7.GeoCountDownTimer(s6.daysInFuture(5));
        System.out.println("Future date should be '1/7/2018");
        System.out.println("Actual date: " + s7);
    }
}