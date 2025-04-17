package Adapter.classadapter;

import Adapter.calendar.NewDateInterface;

public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();

        date.setYear(2024);
        date.setMonth(4);
        date.setDay(17);

        System.out.println("Initial Date: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());

        date.advanceDays(5);
        System.out.println("After 5 Days: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
    }
}
