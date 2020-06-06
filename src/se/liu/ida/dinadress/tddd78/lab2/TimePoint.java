package se.liu.ida.dinadress.tddd78.lab2;

public class TimePoint {
    private String time;
    private int hour;
    private int minute;

    public TimePoint(final String time) {
        String[] parts = time.split(":");
	this.hour = Integer.parseInt(parts[0]);
	this.minute = Integer.parseInt(parts[1]);
	this.time = time;
    }

    public int getHour() {
	return hour;
    }

    public int getMinute() {
	return minute;
    }

    public String toString() {
	return time;
    }
}
