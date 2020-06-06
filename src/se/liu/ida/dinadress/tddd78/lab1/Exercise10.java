package se.liu.ida.dinadress.tddd78.lab1;

import javax.swing.*;

public class Exercise10 {

    public static void main(String[] args) {
	int tal = 16777217;
	double decimaltal = tal;
	int tillbaka = (int)decimaltal;
	int big = 2147483647;
	long bigger = (long)big + 1; // funkar lika bra som long bigger = big + 1L
	/* VIKTIGT: Om det är olika storlek/precision på de ingående talen
	kommer det mindre att konverteras till den större typen och
	 resultatet vara av den större typen
	 */
	System.out.println("tal is " + tal );
	System.out.println("decimaltal is " + decimaltal);
	System.out.println("tillbaka is " + tillbaka);
	System.out.println("big is " + big);
	System.out.println("bigger is " + bigger);
    }






}