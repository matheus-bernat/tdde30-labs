package se.liu.ida.dinadress.tddd78.lab3;

import java.awt.*;
import java.util.ArrayList;

public class TestCircle
{
    public static void main(String[] args) {
	final ArrayList<Circle> circles = new ArrayList<>();
	Circle circleOne = new Circle(1, 2, 3, Color.black);
	Circle circleTwo = new Circle(3,1,1, Color.blue);
	Circle circleThree = new Circle(1, 2, 5, Color.yellow);

	circles.add(circleOne);
	circles.add(circleTwo);
	circles.add(circleThree);

	for (Circle circle : circles) {
	    System.out.println("circle's x is " + circle.getX() + " and circle's y is " + circle.getY());
	    
	}




    }
}
