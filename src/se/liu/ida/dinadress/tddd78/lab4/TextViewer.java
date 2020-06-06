package se.liu.ida.dinadress.tddd78.lab4;

import javax.swing.*;
import java.awt.*;

public class TextViewer extends JComponent {

    final int FONT_SIZE = 15;
    final int LEFT_ALIGNED = 0;
    final int ROW_DISTANCE = 1;
    final int PARAGRAPH_DISTANCE = 4;

    private int startX = LEFT_ALIGNED;
    private int paragraph = 0;
    private int row = 0;

    public TextViewer() throws HeadlessException {
        final int WIDTH = 600;
        final int HEIGHT = 300;
	setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public static void main(String[] args) {
	JFrame frame = new JFrame("Texas Viewer");
	frame.add(new TextViewer()); // FRÅGA: när o var sker anropet till paintComponent() ?
	frame.pack();
	frame.setVisible(true);
    }

    public void drawRow(Graphics g, String text) {
        int startY = (row + 1)*FONT_SIZE + row*ROW_DISTANCE + paragraph*PARAGRAPH_DISTANCE;
        g.drawString(text, startX, startY);
        row++;
    }

    @Override protected void paintComponent(final Graphics g) {
	g.setColor(Color.BLACK);
	g.setFont(new Font("serif", Font.ITALIC, FONT_SIZE));

	drawRow(g, "This is the first line of the first paragraph of text.");
	drawRow(g, "It is followed by the second line of text.");
	drawRow(g, "Which is followed by the third line of text."); paragraph++;

	drawRow(g, "Start of the second paragraph of text.");
	drawRow(g, "Continuation of the second paragraph of text.");
	drawRow(g, "Conclusion of the second paragraph of text."); paragraph++;

	drawRow(g, "Start of the third paragraph of text.");
	drawRow(g, "Continuation of the third paragraph of text.");
	drawRow(g, "Conclusion of the third paragraph of text.");
    }
}
