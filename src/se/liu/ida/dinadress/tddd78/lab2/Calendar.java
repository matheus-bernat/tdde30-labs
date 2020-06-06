package se.liu.ida.dinadress.tddd78.lab2;

import java.util.ArrayList;
import java.util.List;

public class Calendar
{
    private List<Appointment> appointments;

    public Calendar() {
        appointments = new ArrayList<>();
    }

    public void show() {
	for (Appointment appointment : appointments) {
	    System.out.println(appointment);
	}
    }

    public void book(int year, String month, int day, String start, String end, String subject) {

        int monthNumber = Month.getMonthNumber(month);
        String[] startTime = start.split(":");
	String[] endTime = end.split(":");

	int hourStart = Integer.parseInt(startTime[0]);
	int minuteStart = Integer.parseInt(startTime[1]);

	int hourEnd = Integer.parseInt(endTime[0]);
	int minuteEnd = Integer.parseInt(endTime[1]);

        if (year < 2018) {
            throw new IllegalArgumentException("Ain't possible to book appointments in the past mate");
	} else if (!(0 <= hourStart && (23 >= hourEnd))) {
	    throw new IllegalArgumentException("Impossible hour");
	} else if (!(0 <= minuteStart && (59 >= minuteEnd))) {
	    throw new IllegalArgumentException("Impossible minute");
	}

	Month newMonth = new Month(month, Month.getMonthNumber(month), Month.getMonthDays(month));
        Date newDate = new Date(year, newMonth, day);
        TimePoint timePoint1 = new TimePoint(start);
	TimePoint timePoint2 = new TimePoint(end);
	TimeSpan timeSpan = new TimeSpan(timePoint1, timePoint2);
	Appointment appointment = new Appointment(subject, newDate, timeSpan);

	appointments.add(appointment);
    }
}


