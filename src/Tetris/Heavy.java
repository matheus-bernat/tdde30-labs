package Tetris;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents special type of collision Heavy, a powerUp class.
 */
public class Heavy implements FallHandler
{
    /**
     * Checks if there is a collision based on the Heavy physics of it.
     * First of all it detects a collision (returns true) when a not-empty block comes in contact with another
     * not-empty block. Otherwise, we call other functions in order to detect if it's possible to press down
     * that column (isFreeBelow()), an then if so call that operation (findCollision()).
     * @param board Board object where the operations take place
     * @return boolean vriable representing whether a collision was detected or not.
     */
    public boolean hasCollision(Board board) {
	if (board.getFalling() != null) {
	    int columnsFree = 0;
	    int overlappingSquares = 0;
	    List<Integer> listOfColumnsPressed = new ArrayList<>();
	    for (int column = 0; column < board.getFalling().getSize(); column++) {
                for (int row = 0; row < board.getFalling().getSize(); row++) {
                    if (board.getFalling().getSquareType(column, row) != SquareType.EMPTY && (
                    	board.getSquareType(column + board.getFallingX() , row + board.getFallingY())
			== SquareType.OUTSIDE)) {
                        return true;
                    }

                    else if ((board.getFalling().getSquareType(column, row) != SquareType.EMPTY &&
			     board.getSquareType(column + board.getFallingX() , row + board.getFallingY())
			     != SquareType.EMPTY)) {

			overlappingSquares++;
			if (isFreeBelow(board, column, row)) {
			    listOfColumnsPressed.add(Integer.valueOf(column));

			    columnsFree++;
			}
		    }
                }
            }
            if (columnsFree != overlappingSquares) {
	        return true; }

	    else {
		for (Integer columnToBePressed: listOfColumnsPressed) {
		    findCollision(board, columnToBePressed);
		}
	        return false;
	    }
        }
        return false;
    }

    /**
     * Function that returns a description of the FallHandler mode.
     * @return string representing the mode
     */
    public String getDescription() { return "HEAVY!"; }

    /**
     * Checks whether there is some support under the falling object that prevents it from
     * pressing down the respecitve columns.
     */
    public boolean isFreeBelow(Board board, int squareColumn, int squareRow) {
        int numberOfEmptyElements = 0;
        for (int row = squareRow + board.getFallingY(); row < board.getHeight(); row++) {
            if (board.getSquareType(squareColumn + board.getFallingX(), row) == SquareType.EMPTY) {
                numberOfEmptyElements++;
            }
    	}
    	return (numberOfEmptyElements != 0);
    }

    /**
     * Finds the places where colisions happened. Then it calls the function pressDownSquares()
     * whose mission is to finally press down the squares a step.
     */
    public void findCollision(Board board, int columnToBePressed) {
        for (int row = 0; row < board.getFalling().getSize(); row++) {
            for (int column = 0; column <  board.getFalling().getSize(); column++) {
		if (board.getFalling().getSquareType(column, row) != SquareType.EMPTY &&
		    board.getSquareType(column + board.getFallingX (), row + board.getFallingY())!= SquareType.EMPTY) {
		    board.pressDownSquares(columnToBePressed, row);
		}
	    }
	}
    }
}

