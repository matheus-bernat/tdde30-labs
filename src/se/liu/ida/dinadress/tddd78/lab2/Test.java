package se.liu.ida.dinadress.tddd78.lab2;

public class Test
{
    public static void main(String[] args) {
	Calendar myCalendar = new Calendar();
	myCalendar.book(2018, "jul", 22, "18:00", "24:00", "VM match!");
	myCalendar.book(2018, "jun", 15, "15:47", "21:20", "Julie's bday");
	myCalendar.book(2020, "aug", 17, "12:30", "13:00", "Arriving in Palo Alto!");
	myCalendar.book(2022, "jun", 02, "16:50", "23:00", "Done!");
	myCalendar.book(2018, "oct", 07, "18:00", "20:00", "My bday!");
	myCalendar.book(2025, "jan", 28, "18:00", "20:00", "Nollvisionen!");

	myCalendar.show();
    }
}
