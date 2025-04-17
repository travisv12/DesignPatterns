package Adapter.classadapter;

import Adapter.calendar.NewDateInterface;

public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();

        date.setYear(2024);
        date.setMonth(4);  // April
        date.setDay(17);

        System.out.println("Initial Date: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());

        date.advanceDays(10);
        System.out.println("After Advancing 10 Days: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
    }
}
