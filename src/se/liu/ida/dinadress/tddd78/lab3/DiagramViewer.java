package se.liu.ida.dinadress.tddd78.lab3;

import javax.swing.*;
import java.awt.*;

public class DiagramViewer
{
    public static void main(String[] args) {

	DiagramComponent comp = new DiagramComponent();

	// Creating shapes
	Circle circleOne = new Circle(50, 32, 78, Color.black);
	Circle circleTwo = new Circle(78, 104, 102, Color.blue);
	Circle circleThree = new Circle(39, 255, 33, Color.yellow);
	Rectangle rectOne = new Rectangle(99, 40, 88, 44, Color.blue);
	Rectangle rectTwo = new Rectangle(5, 8, 700, 1000, Color.red);
	Text stringOne = new Text(90, 34, 12, Color.red, "tja");
	Text stringTwo = new Text(200, 150, 20, Color.gray, "hahahahahhah");

	// Adding shapes to the comp ArrayList
	comp.addShape(circleOne);
	comp.addShape(circleTwo);
	comp.addShape(circleThree);
	comp.addShape(rectOne);
	comp.addShape(rectTwo);
	comp.addShape(stringOne);
	comp.addShape(stringTwo);

	// Show frame with shapes in it

	JFrame frame = new JFrame("Mitt fönster");
	frame.setLayout(new BorderLayout());
	frame.add(comp, BorderLayout.CENTER);
	frame.setSize(800, 600);
	frame.setVisible(true);
    }
}
