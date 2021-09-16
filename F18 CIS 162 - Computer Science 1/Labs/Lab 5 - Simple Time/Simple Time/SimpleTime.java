import java.text.*;

/**
 * Write a description of class SimpleTime here.
 *
 * @author (Nick Layman)
 * @version (9/25/2018)
 */
public class SimpleTime{
    int hours;
    int minutes;
    int seconds;
    String time;
    
    DecimalFormat two = new DecimalFormat("00");
    
    public SimpleTime(int h, int m, int s){
        hours = h;
        minutes = m;
        seconds = s;
    }
    
    public SimpleTime(){
        hours = 0;
        minutes = 0;
        seconds = 0;
    }
    
    public boolean isMidnight(){
        return hours == 0 && minutes == 0 && seconds == 0;
    }
    
    public boolean isNoon(){
        return hours == 12 && minutes == 0 && seconds == 0;
    }
    
    public boolean isLunchTime(){
        return hours == 12 || (hours == 13 && minutes == 0 && seconds == 0);
    }
    
    public String toString(){
            return hours + ":" + two.format(minutes) + ":" + two.format(seconds);
    }
    
    public void increment(){
        seconds += 1;
        if (seconds == 60){
            seconds = 0;
            minutes += 1;
            if (minutes == 60){
                minutes = 0;
                hours += 1;
                if (hours == 24){
                    hours = 0;
                }
            }
        }
    }
    
    public static void main(){
        SimpleTime st = new SimpleTime(12,31,58);
        System.out.println(st.toString());
        System.out.print("It is ");
        if(!st.isMidnight())
            System.out.print("not ");
        System.out.println("midnight.");

        System.out.print("It is ");
        if(!st.isNoon())
            System.out.print("not ");
        System.out.println("noon.");

        System.out.print("It is ");
        if(!st.isLunchTime())
            System.out.print("not ");
        System.out.println("lunch time.");

        System.out.println("And the next 5 seconds are:");
        st.increment();
        System.out.println(st.toString());
        st.increment();
        System.out.println(st.toString());
        st.increment();
        System.out.println(st.toString());
        st.increment();
        System.out.println(st.toString());
        st.increment();
        System.out.println(st.toString());
    }

}
