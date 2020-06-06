package se.liu.ida.dinadress.tddd78.lab3;

import java.awt.*;

public class Rectangle extends AbstractShape
{
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override public String toString() {
	return "Rectangle{" + "x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + ", color=" + color + '}';
    }

    @Override public void draw(final Graphics g) {
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }
}
