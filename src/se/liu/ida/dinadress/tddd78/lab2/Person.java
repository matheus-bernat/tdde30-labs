package se.liu.ida.dinadress.tddd78.lab2;

import java.time.LocalDate;
import java.time.Period;

public class Person
{
    private String name;
    private LocalDate birthDay;

    public Person(final String name, LocalDate birthDay) { // konstruktorn
	this.name = name;
	this.birthDay = birthDay;
    }

    public static void main(String[] args) { // main ska va static o public
	Person matheus = new Person("Matheus", LocalDate.of(1998, 10, 7));
	Person julie = new Person("Julie", LocalDate.of(2000, 06, 15));
	Person stefan = new Person("Stefan", LocalDate.of(1974, 9, 3));
	System.out.println(matheus);
	System.out.println(julie);
	System.out.println(stefan);
    }

    public int getAge() {
	Period period = Period.between(birthDay, LocalDate.now());
	int yearsGone = period.getYears();
	return yearsGone;
    }

    @Override public String toString() {
	return name + " " + getAge();
    }
}


