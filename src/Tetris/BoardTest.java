package Tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Class that runs the code from within its main function.
 */
final public class BoardTest
{
    final static int WINDOW_WIDTH = 14;
    final static int WINDOW_HEIGHT = 20;
    final static int DELAY = 250;

    private BoardTest() {}

    /**
     * Creates the Board object and the UI object (TetrisFrame). It calls the function tick()
     * repeatedly with a given DELAY of time.
     * @param args null
     */
    public static void main(String[] args) {

	Board board = new Board(WINDOW_WIDTH, WINDOW_HEIGHT);
	TetrisFrame frame = new TetrisFrame(board, "Tetris");
	board.addBoardListener(frame.getTetrisComponent());

	final Action doOneStep = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	        board.tick();

	        frame.handleScore(board);
	        frame.updatePowerUpBar(board);

	        /* Restarts the board if not the user quits it first in the function restartFrame(). */
	        if (board.isIsGameOver()) {
		    frame.restartFrame();
	            board.createEmptyBoard();
	       }
	    }
	};

	final Timer clockTimer = new Timer(DELAY, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();
    }


}