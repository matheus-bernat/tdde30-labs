package Tetris;

/**
 * Class that represents special type of collision FallThtough, a powerUp class.
 */
public class Fallthrough implements FallHandler
{
    public boolean hasCollision(Board board) {
        if (board.getFalling() != null) {
            for (int column = 0; column < board.getFalling().getSize(); column++) {
                for (int row = 0; row < board.getFalling().getSize(); row++) {
                    if (board.getFalling().getSquareType(column, row) != SquareType.EMPTY && (
			board.getSquareType(column + board.getFallingX() , row + board.getFallingY())
			                                                                == SquareType.OUTSIDE)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public String getDescription() {
        return "FALL THROUGH!";
    }
}
