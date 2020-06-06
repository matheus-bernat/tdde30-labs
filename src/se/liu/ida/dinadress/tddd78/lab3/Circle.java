package se.liu.ida.dinadress.tddd78.lab3;

import java.awt.*;

public class Circle extends AbstractShape
{
    private int radius;

    public Circle(int x, int y, int radius, Color color) {
        super(x, y, color);

        if(radius < 0) {
            throw new IllegalArgumentException("Negative radius!");
        }
        this.radius = radius;
    }
/*
    public boolean equals(Object other) {
        if (!super.equals(other)) return false;

        return this.radius == that.radius;
    }*/

    @Override public String toString() {
        return "Circle{" + "x=" + getX() + ", y=" + getY() + ", radius=" + radius + ", color=" + getColor() + '}';
    }

    @Override public void draw(final Graphics g) {
    	g.setColor(color);
        g.drawOval(x, y, 2 * radius, 2*radius);
    }

    public int getRadius() {
            return radius;
        }
}
