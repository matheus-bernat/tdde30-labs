package Tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.AbstractMap;
import java.util.EnumMap;

/**
 * Class that makes the components graphical and also handles inputs from the user
 * through the function keyBind().
 */
public class TetrisComponent extends JComponent implements BoardListener
{
    private Board board;
    private final AbstractMap<SquareType,Color> colorMap;
    final static int PIXEL = 30;

    /**
     * Constructor. Initializes the two private fields, and calls the function keyBind() that
     * takes care of user input via keystrokes.
     * @param board Board object
     * @param map EnumMap object containing the information of the colors each of the SquareTypes have.
     */
    public TetrisComponent(final Board board, AbstractMap<SquareType,Color> map) {
        this.board = board;
        this.colorMap = map;
        keyBind();
    }

    /**
     * Gets the preferred size of the Board object.
     * @return a Dimension object that encapsulates the width and th eheight of the Board component.
     */
    public Dimension getPreferredSize() {
        return new Dimension(PIXEL*board.getWidth(),PIXEL*board.getHeight());
    }

    /**
     * Goes through all the SquareTYpes in the board and drwas them.
     * @param g Graphics object
     */
    @Override protected void paintComponent(final Graphics g) {
	super.paintComponent(g);

	for (int column = 0; column < board.getWidth(); column++) {
	    for (int row = 0; row < board.getHeight(); row++) {
		Graphics2D g2d;
		g2d = (Graphics2D) g;

	        SquareType square = board.getSquareAt(column, row);

		Color color = colorMap.get(square);
		g2d.setColor(color);
		g2d.fillRect(column*PIXEL, row*PIXEL, PIXEL, PIXEL);
		g2d.setColor(Color.blue);
		g2d.drawRect(column*PIXEL, row*PIXEL, PIXEL, PIXEL);
	    }
	}
    }

    public static EnumMap<SquareType,Color>  createEnumMap() {
	EnumMap<SquareType,Color> colorMap = new EnumMap<>(SquareType.class);
	colorMap.put(SquareType.EMPTY, Color.BLACK);
	colorMap.put(SquareType.I, Color.RED); // index 1
	colorMap.put(SquareType.O, Color.green); // index 2
	colorMap.put(SquareType.T, Color.gray); // index 3
	colorMap.put(SquareType.S, Color.magenta); // index 4
	colorMap.put(SquareType.Z, Color.WHITE); // index 5
	colorMap.put(SquareType.J, Color.cyan); // index 6
	colorMap.put(SquareType.L, Color.YELLOW); // index 7
	return colorMap;
    }

    /**
     * Reapints the board, implements methods from BoardListener
     */
    @Override public void boardChanged() {
        repaint();
    }

    /**
     * Binds a keystroke to a certain action, and then calls that action.
     */
    public void keyBind() {
	this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "moveBlockRight");
	this.getActionMap().put("moveBlockRight", moveBlockRight);

	this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "moveBlockLeft");
	this.getActionMap().put("moveBlockLeft", moveBlockLeft);

	this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "rotateBlockRight");
	this.getActionMap().put("rotateBlockRight", rotateBlockRight);

	this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "rotateBlockLeft");
	this.getActionMap().put("rotateBlockLeft", rotateBlockLeft);
    }

    /**
     * Calls a function in Board class that makes the block move right.
     */
    public final Action moveBlockRight = new AbstractAction() {
        @Override public void actionPerformed(final ActionEvent e) {
            board.moveRight(); }
    };
    /**
     * Calls a function in Board class that makes the block move left
     */
    public final Action moveBlockLeft = new AbstractAction() {
        @Override public void actionPerformed(final ActionEvent e) {
            board.moveLeft(); }
        };

    /**
     * Calls a function in Board class that makes the block rotate right
     */
    public final Action rotateBlockRight = new AbstractAction() {
        @Override public void actionPerformed(final ActionEvent e) {
            board.rotateRight();
        }
    };

    /**
     * Calls a function in Board class that makes the block rotate left
     */
    public final Action rotateBlockLeft = new AbstractAction() {
        @Override public void actionPerformed(final ActionEvent e) {
            board.rotateLeft();
        }
    };
}

