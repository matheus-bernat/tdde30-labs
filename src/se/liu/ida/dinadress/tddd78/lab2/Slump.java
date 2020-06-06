package se.liu.ida.dinadress.tddd78.lab2;

import java.util.Random;

public class Slump {
    public static void main(String[] args) {
        Random rnd = new Random();
        rnd.nextLong(); // nextLong() är en metod som finns i klassen Random()

        int i  = 0;
        while(i < 25) {
            System.out.println(rnd.nextInt(25)); // nextInt är också en metod som finns i klassen Random().
            i++;
        }
    }
}