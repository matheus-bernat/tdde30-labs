package se.liu.ida.dinadress.tddd78.lab1;

import javax.swing.*;

public class Exercise9 {

    public static void main(String[] args) {
	String input = JOptionPane.showInputDialog("Enter a value");
	double number = Double.parseDouble(input);
	double res = findRoot(number);
	System.out.println("The sqrt of " + input + " is " + res);
    }

    public static double findRoot(double number) {
        double x = number;
        for (int i = 0; i < 10; i++) {
            x -= (x *x - number)/(2*x);
	}
	return x;
    }




}