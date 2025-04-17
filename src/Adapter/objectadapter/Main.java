package Adapter.objectadapter;

import Adapter.calendar.NewDateInterface;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        NewDateInterface date = new CalendarToNewDateAdapter(calendar);

        date.setYear(2024);
        date.setMonth(4);  // April
        date.setDay(17);

        System.out.println("Initial Date: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());

        date.advanceDays(15);
        System.out.println("After Advancing 15 Days: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
    }
}

