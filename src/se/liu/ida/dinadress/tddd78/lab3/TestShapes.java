package se.liu.ida.dinadress.tddd78.lab3;

import java.awt.*;
import java.util.ArrayList;

public class TestShapes
{
    public static void main(String[] args) {
	final ArrayList<Shape> shapes = new ArrayList<>();

	Circle circleOne = new Circle(1, 2, 3, Color.black);
	Circle circleTwo = new Circle(3, 1, 1, Color.blue);
	Circle circleThree = new Circle(1, 2, 5, Color.yellow);
	Rectangle rectOne = new Rectangle(1, 1, 3, 4, Color.blue);
	Rectangle rectTwo = new Rectangle(5, 8, 7, 2, Color.red);
	Text stringOne = new Text(0, 0, 3, Color.green, "abc");
	Text stringTwo = new Text(2, 2, 2, Color.gray, "oj");

	shapes.add(circleOne); // FRÅGA: hur kan vi kan lägga till saker i listan om det är en final?
	shapes.add(circleTwo);
	shapes.add(circleThree);
	shapes.add(rectOne);
	shapes.add(rectTwo);
	shapes.add(stringOne);
	shapes.add(stringTwo);

	/*for (Shape shape : shapes) {
	    shape.draw();
	}*/
    }
}
