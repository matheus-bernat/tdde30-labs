package se.liu.ida.dinadress.tddd78.lab1;

import javax.swing.*;

public class Exercise4 {

    public static void main(String[] args) {
      for (int i = 0; i <= 10; i++) {
        System.out.println(i + "-fakultet: " + factorial(i));
      }
    }
    /**
    * Calculates f! given f.
    * @param f
    * @return f!
    */
    private static int factorial(int f) {
        int result = 1;
	if (f == 0) {
	    return 1;
	} else {
	    for (int i = 1; i <= f; i++) {
		result *= i;
	    }
	    return result;
	}
    }
}


