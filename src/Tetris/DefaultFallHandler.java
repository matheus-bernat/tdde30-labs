package Tetris;

/**
 * Class that handles normal standard collisions.
 */
public class DefaultFallHandler implements FallHandler
{
    /**
     * Checks if there is a collision based on the deafault physics of it. It detects a collision (returns true)
     * when a non-empty block comes in contact with another non-empty block. Otherwise, returns false.
     * @param board Board object where the operations take place
     * @return boolean variable representing whether a collision was detected or not.
     */
    public boolean hasCollision(Board board) {
    	if (board.getFalling() != null) {
    	    for (int column = 0; column < board.getFalling().getSize(); column++) {
    		for (int row = 0; row < board.getFalling().getSize(); row++) {
    		    if (board.getFalling().getSquareType(column, row) != SquareType.EMPTY &&
    			board.getSquareType(column + board.getFallingX() , row + board.getFallingY())
			  								!= SquareType.EMPTY) {
    			return true;
    		    }
    		}
    	    }
    	    return false;
    	}
    	return false;
    }

    /**
     * Function that returns a description of the FallHandler mode.
     * @return string representing the mode
     */
    public String getDescription() {
        return "Standard";
    }
}
