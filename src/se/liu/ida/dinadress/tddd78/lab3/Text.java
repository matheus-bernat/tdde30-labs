package se.liu.ida.dinadress.tddd78.lab3;

import java.awt.*;

public class Text extends AbstractShape
{
    private int size;
    private String text;

    public Text(int x, int y, int size, Color color, String text) {
        super(x, y, color);
        this.size = size;
        this.text = text;
    }

    @Override public String toString() {
	return "Text{" + "size=" + size + ", text='" + text + '\'' + ", x=" + x + ", y=" + y + ", color=" + color + '}';
    }

    @Override public void draw(final Graphics g) {
        g.setColor(color);
        g.setFont(new Font("serif", Font.PLAIN, size));
        g.drawString(text, x, y);
    }
}
