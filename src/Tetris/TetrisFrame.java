package Tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class that represents the graphic interface. Its task is to show the playfield and let
 * the user interact with it. It contains functions that updates the flags shown in the frame.
 */
public class TetrisFrame extends JFrame
{
    private TetrisComponent tetrisComponent;
    private int playerScore = 0;

    private JMenuBar menuBar;
    private JMenuItem scoreItem;
    private JMenuItem powerUpMode;

    /**
     * Construcotr of the TetrisFrame object. Cretes bars, menus and buttons to be pressed, and sets it as visible.
     * @param board Board object
     * @param title string that gives the name of the window opened
     * @throws HeadlessException when there's no title given as parameter of the superclass.
     */
    public TetrisFrame(Board board, String title) throws HeadlessException {
	super(title);

	/* Creates a TetrisComponent and adds it to the frame:*/
	tetrisComponent = new TetrisComponent(board, TetrisComponent.createEnumMap());
	this.add(tetrisComponent, BorderLayout.CENTER);

	/*Creates a menu bar and adds it to the frame:*/
	this.menuBar = new JMenuBar();
	final JMenu file = new JMenu("File");
	final JMenuItem exit = new JMenuItem("Exit");

	this.scoreItem = new JMenuItem("Score:   " + String.valueOf(playerScore));
	this.powerUpMode = new JMenuItem("Mode: " + board.getFallHandler().getDescription());

	file.add(exit);

	this.menuBar.add(file);
	this.menuBar.add(scoreItem);
	this.menuBar.add(powerUpMode);

	this.setJMenuBar(this.menuBar);

	exit.addActionListener(new QuitAction());

	this.pack(); this.setVisible(true);
    }

    /**
     * Updates the powerup icon in the bar.
     * @param board Board object
     */
    public void updatePowerUpBar(Board board) {
	menuBar.remove(powerUpMode);
	powerUpMode = new JMenuItem("Mode: " + board.getFallHandler().getDescription());
	this.menuBar.add(powerUpMode);
	this.setJMenuBar(this.menuBar);
    }

    /**
     * Updates the score icon in the bar.
     */
    public void updateScore() {
        menuBar.remove(scoreItem);
	scoreItem = new JMenuItem("Score:   " + String.valueOf(playerScore));
	this.menuBar.add(scoreItem);
	this.setJMenuBar(this.menuBar);
    }

    /**
     * Resets the score in the icon to 0.
     */

    public void resetScore() {
        playerScore = 0;
    }

    /**
     * Gives the player points depending on the amount of rows he achieved to remove.
     * @param board from this we'll take the number of removed rows and then habdle the score.
     */
    public void handleScore(Board board) {
        if (board.getNumberOfRowsRemoved() != 0) {
            switch(board.getNumberOfRowsRemoved()) {
                case 1:
                    playerScore += 100;
                    break;
	        case 2:
	            playerScore += 300; /*will keep it like that, unnecessary to delare it before*/
	            break;
	        case 3:
	            playerScore += 500; /*will keep it like that, unnecessary to delare it before*/
	            break;
	        case 4:
	            playerScore += 800; /*will keep it like that, unnecessary to delare it before*/
	            break;
	        default:
	            break;
            }
        }
        updateScore();
    }

    /**
     * Handles the input from the user when it clicks at the icons in the bar.
     */
    private class QuitAction implements ActionListener {
	public void actionPerformed(final ActionEvent e) {
	    Object[] options = { "Yes", "No" };
	    int optionChosen = JOptionPane
		    .showOptionDialog(TetrisFrame.this, "Are you sure?",
				      "Titel", JOptionPane.YES_NO_OPTION,
				      JOptionPane.QUESTION_MESSAGE,
				      null, options, options[1]);
	    if (optionChosen == 0) { System.exit(0); }
	}
    }

    /**
     * Returns the TetrisComponent object created in here.
     * @return TetrisComponent object.
     */
    public TetrisComponent getTetrisComponent() {
        return tetrisComponent;
    }

    /**
     * Executes the necessary procedures to restart the gameframe: asks questions to the users,
     * adds the score to the list, shows the list of all scores, and in the end resets the scores.
     */
    public void restartFrame() {
	JOptionPane.showMessageDialog(this, "                YOU DIED");
	String playerName = JOptionPane.showInputDialog("What is your name?");

	Highscore playerScore = new Highscore(this.playerScore, playerName);
	HighscoreList.getInstance().addToScoreList(playerScore);

	HighscoreList.getInstance().showAllScores();

	Object[] options = {"Oh yeah", "Never again"};
	int option = JOptionPane.showOptionDialog(this,"       Wanna play again? ","Question",
								 JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
								 null, options, options[1]);
	handleInput(option);

	resetScore();
    }

    /**
     * This small function handles the input from the user when a window pops up.
     * @param option answer chosen by the user.
     */
    public static void handleInput(int option) {
    	switch (option) {
    	    case 0:
    	        break;
    	    case 1:
    	        System.exit(0);
    	        break;
    	}
    }
}



