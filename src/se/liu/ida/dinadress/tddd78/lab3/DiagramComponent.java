package se.liu.ida.dinadress.tddd78.lab3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DiagramComponent extends JComponent
{
    private ArrayList<Shape> shapes; //är nog fel. vad e en arrayList<>()? list som innehåller listor?

    public DiagramComponent() {
//	final ArrayList<Shape> shapes = new ArrayList<>();
	shapes = new ArrayList<>();
    }

    @Override protected void paintComponent(final Graphics g) {
	super.paintComponent(g);

	for (Shape shape: shapes) {
	    shape.draw(g);
	}
    }

    public void addShape (Shape form){
        shapes.add(form);
    }
}




