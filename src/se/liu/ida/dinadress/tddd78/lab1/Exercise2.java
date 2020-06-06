package se.liu.ida.dinadress.tddd78.lab1;

import javax.swing.*;

public class Exercise2
{
//    public static void main(String[] args) {
//	int a = 0;
//	for (int i = 0; i < 10; i++) {
//	    a = a + 20;
//	    System.out.println("Nu har a värdet " + a);
//	}
//
//    }
// Övning 2 och 7
    public static void main(String[] args) {
        int min = 10;
        int max = 20;
        String input = JOptionPane.showInputDialog("Type 'for' or 'while'");
        switch (input) {
	    case "for":
		int res1 = sumFor(min, max);
		System.out.println("For-sum is " + res1);
		break;
	    case "while":
		int res2 = sumWhile(min, max);
		System.out.println("While-sum is " + res2);
		break;
	    default:
		System.out.println("You typed wrong dumbass");
	}
    }

    public static int sumFor(int min, int max) {
        int number = 0;
	for (int i = 0; min <= max; min++) {
            number += min;
	}
	return number;
    }

    public static int sumWhile(int min, int max) {
            int res = 0;
            int help_min = min;
            while (help_min <= max) {
                res += help_min;
    	    help_min ++;
    	}
    	return res;
    }









}


