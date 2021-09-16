package Project4;

import java.text.DateFormat;
import java.util.GregorianCalendar;

public class Truck extends Auto {

    private boolean FourByFour;

    public Truck() {
        super();
    }

    public double getBoughtSoldCost(GregorianCalendar SoldDate, double SoldCost) {
        return SoldCost - boughtPrice;
    }

    public Truck(boolean fourByFour) {
        FourByFour = fourByFour;
    }

    public Truck(GregorianCalendar boughtOn, String autoName, double boughtPrice, String trim, boolean fourByFour) {
        super(boughtOn, autoName, boughtPrice, trim);
        FourByFour = fourByFour;
    }

    public boolean isFourByFour() {
        return FourByFour;
    }

    public void setFourByFour(boolean fourByFour) {
        FourByFour = fourByFour;
    }


    @Override
    public String toString() {
        String soldOnDateStr;

        String boughtOnDateStr;
        if (getBoughtOn() == null)
            boughtOnDateStr = "";
        else
            boughtOnDateStr = DateFormat.getDateInstance(DateFormat.SHORT)
                    .format(getBoughtOn().getTime());

        return "Truck{" +
                "FourByFour=" + FourByFour +
                ", boughtOn=" + boughtOnDateStr +
                ", autoName='" + autoName + '\'' +
                ", boughtCost=" + boughtPrice +
                ", trim='" + trim + '\'' +
                '}';
    }
}