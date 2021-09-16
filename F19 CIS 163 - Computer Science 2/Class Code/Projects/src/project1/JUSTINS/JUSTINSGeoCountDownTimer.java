//package project1.JUSTINS;
//
//import project1.GeoCountDownTimer;
//
//import java.io.*;
//import java.util.Scanner;
//
///************************************************************************
// * This program builds a GUI date clock and counts up to a desired date.
// * Multiple functions are used to count the clock
// *
// * @author Justin Von Kulajta Winn
// *@version 1.8
// ***********************************************************************/
//
//public class JUSTINSGeoCountDownTimer {
//
//    /** this is the number of months for a give date */
//    private int month;
//
//    /** this is the number of years for a given date */
//    private int year;
//
//    /** this is the number of days for a given date */
//    private int day;
//
//    /** this is the minimum year the count down timer can go */
//    private static final int MINYEAR = 2015;
//
//
//
//    /** this is the array for days in the month */
//    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31,
//            31, 30, 31, 30, 31};
//
//    /** this is the array that holds the titles of each month */
//    private static final String[] MONTHS = {"", "January", "February",
//            "March", "April", "May", "June", "July", "August", "September",
//            "October", "November", "December"};
//
//    /************************************************************************
//     * This is a basic constructor has no inputs or returns. This sets the
//     * date to the earliest date possible
//     ************************************************************************/
//    public GeoCountDownTimer() { //ASK PROFESSOR WHY THIS NEEDS TO BE PRIVATE; CODE DOES NOT BUILD WITHOUT BEING PUBLIC
//        month = 1;
//        year = 2015;
//        day = 1;
//    }
//
//    /************************************************************************
//     *This is a constructor that sets the month, day, and year
//     * @param month is the month to be set as the instance variable
//     * @param day is the day to be set as the instance variable
//     * @param year is the year to be set as the instance variable
//     * @throws IllegalArgumentException is thrown when the day, month or year
//     *                                 is out of its respective range
//     ************************************************************************/
//    public GeoCountDownTimer(int month, int day, int year) {
//        if (month < 1 || day < 1 || year < MINYEAR || month > 12)
//            throw new IllegalArgumentException();
//
//        if (!isLeapYear(year)) {
//            if (day > DAYS_IN_MONTH[month])
//                throw new IllegalArgumentException();
//        }
//        else if (month == 2 && day > 29) {
//            throw new IllegalArgumentException();
//        }
//
//        this.month = month;
//        this.day = day;
//        this.year = year;
//    }
//
//    /************************************************************************
//     * This is a constructor that sets the instance variables month, day,
//     * and year to another GeoCountDownTimer
//     * @param other is the GeoCountDownTimer being used to set the instance variables
//     * @throws IllegalArgumentException is thrown when the day, month or year
//     *                                 is out of its respective range
//     ************************************************************************/
//    public void GeoCountDownTimer(GeoCountDownTimer other) {
//        this.month = other.month;
//        this.day = other.day;
//        this.year = other.year;
//    }
//
//    /************************************************************************
//     * This is a constructor that breaks up a string and sets the instance
//     * variables equal to the respective component
//     * @param geoDate is the string that holds the month, day and year
//     *                in the format "xx/xx/xxxx"
//     * @throws IllegalArgumentException is thrown when the day, month or year
//     *                                 is out of its respective range. It is
//     *                                 also used when the string is formatted
//     *                                 incorrectly
//     ************************************************************************/
//    public GeoCountDownTimer(String geoDate) {
//
//        String[] dates = geoDate.split("/");
//        String months;
//        String days;
//        String years;
//        if (dates.length == 3){
//            months = dates[0];
//            days = dates[1];
//            years = dates[2];
//        }
//        else
//            throw new IllegalArgumentException();
//
//        this.month = Integer.parseInt(months);//Converts the Strings into integers
//        this.day = Integer.parseInt(days);
//        this.year = Integer.parseInt(years);
//
//        if (month < 1 || day < 1 || year < MINYEAR || month > 12)
//            throw new IllegalArgumentException();
//
//        if (!isLeapYear(year)) {
//            if (day > DAYS_IN_MONTH[month])
//                throw new IllegalArgumentException();
//        }
//        else if (month == 2 && day > 29) {
//            throw new IllegalArgumentException();
//        }
//
//        }
//
//
//    /************************************************************************
//     * This function checks if the GeoCountDownTimer is equal to the object
//     * sent in
//     * @param other is an object that is likely to be holding a GeoCountDownTimer
//     * @throws IllegalArgumentException when the object is not holding anything
//     *                                 or if the object is not a GeoCountDownTimer
//     * @return true if the month, day, and year match. returns false if they do not
//     ************************************************************************/
//    public boolean equals(Object other) {
//        if (other != null) {
//            if (other instanceof GeoCountDownTimer) {//validates 'other' is a lock type variable
//                GeoCountDownTimer temp = (GeoCountDownTimer) other;//casts other as a GeoCountDownTimer
//                if (this.year == temp.year && this.month == temp.month && this.day == temp.day) {
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        }
//        throw new IllegalArgumentException();
//    }
//
//    /************************************************************************
//     *  This function compares two GeoCountDownTimer variables
//     * @param other is the 2nd GeoCountDownTimer that is being compared to the
//     *              instance variables
//     * @return 1 if this is a later date than other, 0 if they are the same date,
//     *         and -1 if other is a later date this
//     ************************************************************************/
//    public int compareTo(GeoCountDownTimer other) {
//        if (this.year == other.year) {
//            if (this.month > other.month) {
//                return 1;
//            }
//            if (this.month == other.month) {
//                if (this.day > other.day) {
//                    return 1;
//                }
//                if (this.day == other.day) {
//                    return 0;
//                }
//            }
//        } else if (this.year > other.year) {
//            return 1;
//        }
//        return -1;
//    }
//
//    /************************************************************************
//     * This function decreases the date by pDays
//     * @param pDays is the number of days the date is being decreased by
//     * @throws IllegalArgumentException when pDays is negative or the year falls
//     *                                 below the MINYEAR
//     ************************************************************************/
//    public void dec(int pDays) {
//        if (pDays < 0){
//            throw new IllegalArgumentException();
//        }
//        this.day -= pDays;
//
//        while (day < 1) {
//            if (!isLeapYear(year) || month != 2) {
//                if (month == 1) {
//                    day += DAYS_IN_MONTH[month];
//                    month = 12;
//                    year -= 1;
//                } else {
//                    day += DAYS_IN_MONTH[month];
//                    month -= 1;
//                }
//
//            }
//            else{
//                day += 29;
//            }
//        }
//
//        if (MINYEAR > year){
//            throw new IllegalArgumentException();
//        }
//    }
//
//    /************************************************************************
//     * This function decreases the date by 1 day
//     ************************************************************************/
//    public void dec() {
//        dec(1);
//    }
//
//    /************************************************************************
//     *This function increases the date by pDays
//     * @param pDays is the number of days the date is being increased by
//     * @throws IllegalArgumentException when pDays is negative
//     ************************************************************************/
//    public void inc(int pDays) {
//        if (pDays < 0)
//            throw new IllegalArgumentException();
//
//
//        this.day += pDays;
//
//        while (day > DAYS_IN_MONTH[month]) {
//            if (!isLeapYear(year) || month != 2) {
//                if (month == 12) {
//                    day -= DAYS_IN_MONTH[month];
//                    month = 1;
//                    year += 1;
//                } else {
//                    day -= DAYS_IN_MONTH[month];
//                    month += 1;
//                }
//
//            }
//            else{
//                day -= 29;
//                month += 1;
//            }
//        }
//    }
//
//    /************************************************************************
//     * This function increases the date by 1 day
//     ************************************************************************/
//    public void inc() {
//        inc(1);
//    }
//
//    /************************************************************************
//     * This function finds the number of days to go until the date passed
//     * @param fromDate is the string holding the desired date
//     * @throws IllegalArgumentException if the date passed if later than this
//     * @return the numbers of days between the two dates
//     ************************************************************************/
//    public int daysToGo(String fromDate){
//        GeoCountDownTimer temp = new GeoCountDownTimer(fromDate);
//
//        int toGO = 0;
//
//        if (this.compareTo(temp) == -1)
//            throw new IllegalArgumentException();
//
//        while (this.compareTo(temp) > 0){
//            temp.inc();
//            toGO++;
//        }
//        return toGO;
//    }
//
//    /************************************************************************
//     * This date finds the future or past date n days from this.
//     * @param n is the number of days the found date should be from this
//     * @return GeoCountDownTimer temp which is the future/past date found
//     ************************************************************************/
//    public GeoCountDownTimer daysInFuture(int n){
//        GeoCountDownTimer temp = new GeoCountDownTimer(this.toDateString());
//        if (n > 0)
//            temp.inc(n);
//        else if (n < 0) {
//            n = (-1) * n;
//            temp.dec(n);
//        }
//
//        return temp;
//    }
//
//
//    /************************************************************************
//     * This function determines if the current year is a leap year or not
//     * @param year is the year being tested whether or not it is a leap year
//     * @return true if it is a leap year, false if it is not
//     ************************************************************************/
//    public static boolean isLeapYear(int year) {
//        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
//    }
//
//    /************************************************************************
//     * This constructor makes this a copy of the passed GeoCountDownTimer
//     * @param geoCountDown is used to set this's month, day, and year
//     ************************************************************************/
//    public GeoCountDownTimer(GeoCountDownTimer geoCountDown) {
//        this.year = geoCountDown.year;
//        this.month = geoCountDown.month;
//        this.day = geoCountDown.day;
//
//    }
//
//    /************************************************************************
//     * This function checks if the 2 GeoCountDownTimers are equal
//     * @param s1 is the first GeoCountDownTimer
//     * @param s2 is the second GeoCountDownTimer
//     ************************************************************************/
//    public static boolean equals(GeoCountDownTimer s1, GeoCountDownTimer s2) {
//        return (s2.year == s1.year) && (s2.month == s1.month)
//                && (s2.day == s1.day);
//    }
//
//    /************************************************************************
//     * This function returns a string of the date in the form "Month_name day, year
//     * @return is the string holding the month, day, and year in the proper form
//     ************************************************************************/
//    public String toString() {
//        String s = MONTHS[this.month] + " " + this.day + ", " + this.year;
//        return s;
//    }
//
//    /************************************************************************
//     * This function returns a string of the date in the form month/day/year
//     * @return a string holding the month, day and year in the specified form
//     ************************************************************************/
//    public String toDateString() {
//        return month + "/" + day + "/" + year;
//    }
//
//
//    /************************************************************************
//     * This file saves the current date in the given file name
//     * @param filename is the name of the file the data is being saved into
//     ************************************************************************/
//    public void save(String filename) {
//
//        PrintWriter out = null;
//        try {
//            out = new PrintWriter(new BufferedWriter(new FileWriter(
//                    filename)));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        out.println(month);
//        out.println(day);
//        out.println(year);
//
//        out.close();
//    }
//
//    /************************************************************************
//     * This function pulls up the saved month, day, and year and sets this
//     * equal to them
//     * @param fileName is the name of the file the date is being pulled from
//     ************************************************************************/
//    public void load(String fileName) {
//        try {
//
//            // open the data file
//            Scanner fileReader = new Scanner(new File(fileName));
//
//            // read one int
//            this.month = fileReader.nextInt();//change in project by making them year, etc and
//            this.day = fileReader.nextInt();
//            this.year = fileReader.nextInt();//use fileReader.nextInt()
//        } catch (Exception error) {
//            System.out.println("Oops!  Something went wrong.");
//        }
//    }
//
//    /************************************************************************
//     * This is the main function where tests are being run
//     ************************************************************************/
//    public static void main(String[] args) {
//        GeoCountDownTimer s = new GeoCountDownTimer("2/10/2020");
//        System.out.println("Date: " + s);
//
//        GeoCountDownTimer s1 = new GeoCountDownTimer("2/10/2022");
//        System.out.println("Date: " + s1.toString());
//
//        s1.dec(365);
//        System.out.println("Date: " + s1);
//
//        GeoCountDownTimer s2 = new GeoCountDownTimer("2/10/2019");
//        for (int i = 0; i < (365 + 366); i++)
//            s2.inc(1);
//        System.out.println("Date: " + s2);
//
//
//        GeoCountDownTimer s3 =  new GeoCountDownTimer(5, 5, 2019);
//        s3.dec(700);
//        System.out.println("Date " + s3);
//
//        s3.inc(1000);
//        System.out.println("Date: " + s3.toDateString());
//
//        GeoCountDownTimer s4 = new GeoCountDownTimer("11/7/2019");
//        GeoCountDownTimer s5 = new GeoCountDownTimer(s4);
//
//        s4.dec(3660);
//        s5.dec(3660);
//
//        System.out.println("Comparison Tests");
//        System.out.println("If the first timer is greater than the other timer, then the test");
//        System.out.println("returns a 1");
//        System.out.println("If the two timers are equal, the test will return a 0");
//        System.out.println("If the second timer is greater than the first, then the test");
//        System.out.println("returns a -1");
//        System.out.println("Comparison Value: " + s4.compareTo(s5));
//
//        System.out.println("Save/Load Test");
//        GeoCountDownTimer s6 = new GeoCountDownTimer("1/1/2018");
//
//        s6.inc();
//        s6.save("temp.txt");
//
//        s6.load("temp.txt");
//
//        System.out.println("Loaded Date: "+ s6);
//
//        System.out.println("Days To Go Test!");
//
//        System.out.println("Days between s6 and '12/12/2017:' " + s6.daysToGo("12/12/2017"));
//
//        System.out.println("Days in the Future Test");
//
//        GeoCountDownTimer s7 = new GeoCountDownTimer(s6.daysInFuture(5));
//        System.out.println("Future date should be '1/7/2018");
//        System.out.println("Actual date: " + s7);
//    }
//}
