package Adapter.classadapter;

import Adapter.calendar.NewDateInterface;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarToNewDateAdapter extends GregorianCalendar implements NewDateInterface {

    @Override
    public void setDay(int day) {
        set(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public void setMonth(int month) {
        set(Calendar.MONTH, month - 1); // Calendar.MONTH is 0-based
    }

    @Override
    public void setYear(int year) {
        set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        return get(Calendar.MONTH) + 1;
    }

    @Override
    public int getYear() {
        return get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        add(Calendar.DAY_OF_MONTH, days);
    }
}
