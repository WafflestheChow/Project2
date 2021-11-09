package company;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Date212 {
    private int year;
    private int month;
    private int day;
    private String full_date;

    //default constructor
    public Date212(String raw_date) {
        this.full_date = raw_date;
        this.year = Integer.parseInt(raw_date.substring(0, 4));
        this.month = Integer.parseInt(raw_date.substring(4, 6));
        this.day = Integer.parseInt(raw_date.substring(6, 8));
    }
    //get day
    public int getDay() {
        return this.day;
    }
    //get month
    public int getMonth() {
        return this.month;
    }
    //get year
    public int getYear() {
        return this.year;
    }

    //optional boolean value to validate constructor input.
    public boolean isValid(String xDate) {
        return xDate.length() == 8;
    }

    // convert integer value parsed from constructor to a String month.
    private String monthString(int x) {
        return new DateFormatSymbols().getMonths()[x - 1];
    }

    // return formatted date.
    public String toString() {
        return monthString(this.month) + " " + this.day + ", " + this.year;
    }

    //check if dates are equal
    public boolean isEqual(Date212 other) {
        return this.year == other.year
                && this.month == other.month
                && this.day == other.day;
    }

    // checking if the next value being compared to is bigger.
    public boolean compareTo(Date212 other) throws ParseException {
        //set up SimpleDateFormat pattern.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        /*
        Create a Date object and initialize it with the value of original
        date and another date.
        */
        Date date1 = sdf.parse(this.full_date);
        Date date2 = sdf.parse(other.full_date);

        // return an instance of Calendar
        Calendar d1 = Calendar.getInstance();
        Calendar d2 = Calendar.getInstance();
        //set instances to date
        d1.setTime(date1);
        d2.setTime(date2);
        //compare the dates
        return d1.before(d2);
    }
}
