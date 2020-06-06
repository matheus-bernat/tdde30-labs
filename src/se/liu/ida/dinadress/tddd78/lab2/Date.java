package se.liu.ida.dinadress.tddd78.lab2;

public class Date {
    private int year;
    private Month month;
    private int day;

    public Date(final int year, final Month month, final int day) { //entender melhor essa parada de this/self
	this.year = year;
	this.month = month;
	this.day = day;
    }

    public int getYear() {
        return year;
    }

    public Month getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String toString() {
        return year + "/" + Month.getMonthNumber(month.getName()) + "/" + day + " ";
    }
}
