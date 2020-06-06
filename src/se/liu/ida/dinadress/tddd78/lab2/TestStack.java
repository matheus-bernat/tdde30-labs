package se.liu.ida.dinadress.tddd78.lab2;

import java.time.LocalDate;

public class TestStack
{
    public static void main(String[] args) {
	Person matheus = new Person("Matheus", LocalDate.of(1998, 10, 7));
	Person julie = new Person("Julie", LocalDate.of(2000, 06, 15));
	Person stefan = new Person("Stefan", LocalDate.of(1974, 9, 3));
	Person queli = new Person("Queli", LocalDate.of(1976, 04, 13));
	Person stefanie = new Person("Stefanie", LocalDate.of(2000, 7, 13));

	Stack myStack = new Stack();
	myStack.pop();

	myStack.push(matheus);
	myStack.push(julie);
	myStack.push(stefan);
	myStack.push(queli);
	myStack.push(stefanie);

	while (!myStack.isEmpty()) {
	    System.out.println(myStack.pop());
	}
    }
}
