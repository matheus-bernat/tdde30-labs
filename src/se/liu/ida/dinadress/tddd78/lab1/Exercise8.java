package se.liu.ida.dinadress.tddd78.lab1;

import javax.swing.*;

public class Exercise8 {

    public static void main(String[] args) {
        while(true) {
            if (askUser("Quit") && askUser("Really")) {
		System.out.println("too sad");
                break;
	    }
	    else {
		System.out.println("So we keep on playing!");
	    }
	}
//
    }

    public static boolean askUser(String question) {
	return JOptionPane.showConfirmDialog(null, question, "",
				      JOptionPane.YES_NO_OPTION) ==
				      JOptionPane.YES_OPTION;





}


}


