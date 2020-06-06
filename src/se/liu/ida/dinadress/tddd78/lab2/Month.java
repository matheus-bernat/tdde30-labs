package se.liu.ida.dinadress.tddd78.lab2;

public class Month
{
    private String name;
    private int number;
    private int days; // Eftersom vi inte vill att nån annan klass utifrån ska ändra på dem värden, sätter vi dem till private

    public Month(final String name, final int number, final int days) { // varför skriver man final på variablerna här? Ska inte de kunna ändras?
	this.name = name;
	this.number = number; // what is number? tex January: 1, March: 3 ?
	this.days = days; // what is days? total number of days in a month? tex 31 in january?
    }

    public String getName() { return name; }

    public int getNumber() { return number; }

    public int getDays() { return days; }

    public static int getMonthNumber(String name) { // OK
	int monthNumber;
	switch (name) {
	    case "jan":
		monthNumber = 1;
		break;
	    case "feb":
		monthNumber = 2;
		break;
	    case "mar":
		monthNumber = 3;
		break;
	    case "apr":
		monthNumber = 4;
		break;
	    case "may":
		monthNumber = 5;
		break;
	    case "jun":
		monthNumber = 6;
		break;
	    case "jul":
		monthNumber = 7;
		break;
	    case "aug":
		monthNumber = 8;
		break;
	    case "sept":
		monthNumber = 9;
		break;
	    case "oct":
		monthNumber = 10;
		break;
	    case "nov":
		monthNumber = 11;
		break;
	    case "dec":
		monthNumber = 12;
		break;
	    default:
		monthNumber = -1;
	}
	return monthNumber;
    }

    public static int getMonthDays(String name) { // OK
	int days;
	switch (name) {
	    case "jan":
		days = 31;
		break;
	    case "feb":
		days = 28;
		break;
	    case "mar":
		days = 31;
		break;
	    case "apr":
		days = 30;
		break;
	    case "may":
		days = 31;
		break;
	    case "jun":
		days = 30;
		break;
	    case "jul":
		days = 31;
		break;
	    case "aug":
		days = 30;
		break;
	    case "sept":
		days = 30;
		break;
	    case "oct":
		days = 31;
		break;
	    case "nov":
		days = 30;
		break;
	    case "dec":
		days = 31;
		break;
	    default:
		days = -1;
	} return days;
    }
}