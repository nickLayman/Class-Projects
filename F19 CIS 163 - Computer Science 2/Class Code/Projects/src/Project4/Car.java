package Project4;

import java.text.DateFormat;
import java.util.GregorianCalendar;

public class Car extends Auto {

    private boolean turbo;

    public Car() {
    }

    public double getBoughtSoldCost(GregorianCalendar SoldDate, double SoldCost) {
        return SoldCost - boughtPrice;
    }

    public Car(boolean turbo) {
        this.turbo = turbo;
    }

    public Car(GregorianCalendar boughtOn, String autoName, double boughtPrice, String trim, boolean turbo) {
        super(boughtOn, autoName, boughtPrice, trim);
        this.turbo = turbo;
    }

    public boolean isTurbo() {
        return turbo;
    }

    public void setTurbo(boolean turbo) {
        this.turbo = turbo;
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

        String buyerStr;

        return "Car{" +
                "turbo=" + turbo +
                ", boughtOn=" + boughtOnDateStr +
                ", autoName='" + autoName + '\'' +
                ", boughtCost=" + boughtPrice +
                ", trim='" + trim + '\'' +
                '}';
    }
}
