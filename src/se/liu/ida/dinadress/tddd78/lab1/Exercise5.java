package se.liu.ida.dinadress.tddd78.lab1;

import javax.swing.*;

public class Exercise5 {

    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
		System.out.println(i);
	    }
	}
    }//

    public static boolean isPrime(int number) {
        for (int i = 2; i <= number - 1; i++) {
            int rest = number % i;
            if (rest == 0) {
                return false;
	    }
	}
	return true;
    }
}


