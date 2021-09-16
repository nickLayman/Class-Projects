package Project4;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import static org.junit.Assert.*;

public class MySingleLinkedListTest {

    private Car car1;
    private Car car2;
    private Car car3;
    private Car car4;
    private Car car5;
    private Car car6;
    private Truck truck1;
    private Truck truck2;
    private Truck truck3;
    private Truck truck4;
    private Truck truck5;
    private Truck truck6;
    private MySingleLinkedList list = new MySingleLinkedList();

    @Before
    public void createList() {

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        GregorianCalendar temp1 = new GregorianCalendar();
        GregorianCalendar temp2 = new GregorianCalendar();
        GregorianCalendar temp3 = new GregorianCalendar();
        GregorianCalendar temp4 = new GregorianCalendar();
        GregorianCalendar temp5 = new GregorianCalendar();
        GregorianCalendar temp6 = new GregorianCalendar();

        try {
            Date d1 = df.parse("1/20/2010");
            temp1.setTime(d1);
            Date d2 = df.parse("12/20/2018");
            temp2.setTime(d2);
            Date d3 = df.parse("1/20/2019");
            temp3.setTime(d3);
            Date d4 = df.parse("3/20/2019");
            temp4.setTime(d4);
            Date d5 = df.parse("4/20/2019");
            temp5.setTime(d5);
            Date d6 = df.parse("1/20/2020");
            temp6.setTime(d6);


            car1 = new Car (temp1, "Outback", 11000,"LX", false);
            car2 = new Car (temp2, "Chevy", 12000,"EX", false);
            car3 = new Car (temp3, "Focus", 13000,"EX", true);
            car4 = new Car (temp4, "Outback2", 14000,"EX", false);
            car5 = new Car (temp5, "Chevy2", 15000,"LX", true);
            car6 = new Car (temp6, "Focus2", 16000,"LX", true);
            truck1 = new Truck(temp1,"F150",11000,"EX",false);
            truck2 = new Truck(temp2,"F250",12000,"LX",true);
            truck3 = new Truck(temp3,"F350",13000,"EX",false);
            truck4 = new Truck(temp4,"F450",14000,"EX",true);
            truck5 = new Truck(temp5,"F550",15000,"LX",false);
            truck6 = new Truck(temp6,"F650",16000,"EX",true);

            list.add(car1);
            list.add(car2);
            list.add(car3);
            list.add(car4);
            list.add(car5);
            list.add(car6);
            list.add(truck1);
            list.add(truck2);
            list.add(truck3);
            list.add(truck4);
            list.add(truck5);
            list.add(truck6);

        } catch (ParseException e) {
            throw new RuntimeException("Error in testing, creation of list");
        }
    }

    @Test
    // here is the very small example to use.
    public void size() {
        assertEquals(12, list.size());
        createList();
        assertEquals(24, list.size());
        list.remove(0);
        assertEquals(23,list.size());
        list.remove(10);
        assertEquals(22, list.size());
        list.remove(9);
        assertEquals(21, list.size());
        list.remove(0);
        assertEquals(20, list.size());
        list.remove(0);
        assertEquals(19, list.size());
        list.remove(3);
        list.remove(4);
        list.remove(1);
        list.remove(1);
        for (int i = 0; i < 15; i++)
            list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    public void clear() {
        list.clear();
        assertEquals(0, list.size());
        assertNull(list.get(0));
        assertNull(list.remove(0));
    }

    @Test
    public void add1() {
        list.clear();
        list.add(truck3);
        list.add(truck5);
        list.add(truck4);
        list.add(truck2);
        list.add(car2);
        list.add(truck1);
        list.add(car1);
        list.add(car3);
        list.add(car5);
        list.add(truck6);
        list.add(car6);
        list.add(car4);
        assertEquals(12, list.size());
        get3();
    }

    @Test
    public void add2() {
        list.clear();
        list.add(car3);
        list.add(car5);
        list.add(car4);
        list.add(car2);
        list.add(truck2);
        list.add(car1);
        list.add(truck1);
        list.add(truck3);
        list.add(truck5);
        list.add(car6);
        list.add(truck6);
        list.add(truck4);
        assertEquals(12, list.size());
        get3();
    }

    @Test
    public void add3() {
        list.clear();
        list.add(truck6);
        list.add(truck5);
        list.add(truck4);
        list.add(truck3);
        list.add(truck2);
        list.add(truck1);
        list.add(car6);
        list.add(car5);
        list.add(car4);
        list.add(car3);
        list.add(car2);
        list.add(car1);
        assertEquals(12, list.size());
        get3();
    }

    @Test (expected = IllegalArgumentException.class)
    public void get1() {
        list.get(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void get2() {
        list.get(12);
    }

    @Test
    public void get3() {
        assertEquals(car1, list.get(0));
        assertEquals(car2, list.get(1));
        assertEquals(car3, list.get(2));
        assertEquals(car4, list.get(3));
        assertEquals(car5, list.get(4));
        assertEquals(car6, list.get(5));
        assertEquals(truck1, list.get(6));
        assertEquals(truck2, list.get(7));
        assertEquals(truck3, list.get(8));
        assertEquals(truck4, list.get(9));
        assertEquals(truck5, list.get(10));
        assertEquals(truck6, list.get(11));
    }


    @Test (expected = IllegalArgumentException.class)
    public void remove1() {
        list.remove(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void remove2() {
        list.remove(12);
    }

    @Test
    public void remove3() {
        list.remove(11);
        list.remove(6);
        list.remove(5);
        list.remove(0);
        assertEquals(8, list.size());
        assertEquals(car2, list.get(0));
        assertEquals(car5, list.get(3));
        assertEquals(truck2, list.get(4));
        assertEquals(truck5, list.get(7));

        list.remove(1);
        list.remove(4);
        assertEquals(6, list.size());
        assertEquals(car2, list.get(0));
        assertEquals(car4, list.get(1));
        assertEquals(truck2, list.get(3));
        assertEquals(truck4, list.get(4));

        list.remove(0);
        list.remove(1);
        list.remove(1);
        list.remove(1);
        list.remove(1);
        list.remove(0);

        assertNull(list.get(0));
        assertEquals(0, list.size());
    }

    @Test
    public void remove4() {
        createList();
        Random rand = new Random();
        for (int rounds = 0; rounds < 10; rounds++) {
            for (int i = 0; i < 24; i++) {
                list.remove(rand.nextInt(24 - i));
                assertEquals(23 - i, list.size());
            }
            createList();
            createList();
        }
    }

    @Test
    public void remove5() {
        list.remove(null);
    }

    @Test
    public void remove6() {
        list.remove(new Car());
    }

    @Test
    public void remove7() {
        list.remove(truck6);
        list.remove(truck1);
        list.remove(car6);
        list.remove(car1);
        assertEquals(8, list.size());
        assertEquals(car2, list.get(0));
        assertEquals(car5, list.get(3));
        assertEquals(truck2, list.get(4));
        assertEquals(truck5, list.get(7));

        list.remove(car3);
        list.remove(truck3);
        assertEquals(6, list.size());
        assertEquals(car2, list.get(0));
        assertEquals(car4, list.get(1));
        assertEquals(truck2, list.get(3));
        assertEquals(truck4, list.get(4));

        list.remove(car2);
        list.remove(car5);
        list.remove(truck2);
        list.remove(truck4);
        list.remove(truck5);
        list.remove(car4);

        assertNull(list.get(0));
        assertEquals(0, list.size());

        list.remove(car1);
    }

    @Test
    public void display() {
        assertNull(list.toString());
    }
}