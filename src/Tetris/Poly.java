package Tetris;

/**
 * Class that represents a block which is a collection of SquareTypes objects.
 * It has methods to get the size of the poly and also get the SquareType from
 * within the given Poly object.
 */
public class Poly
{
    private SquareType[][] poly;

    /**
     * Constructor of the Poly object
     * @param poly array that is a collection of SquareTypes. Every Poly object has its own.
     */
    public Poly(SquareType[][] poly) {
	this.poly = poly;
    }

    /**
     * Getter that returns the private field of this class "length".
     * @return int length
     */
    public int getSize() { return poly.length; }

    /**
     * Getter that returns the SquareType existant in the Poly object at the given position (column x row)
     * @param column integer representing the column at the Board object
     * @param row integer representing the row at the Board object
     * @return SquareType object
     */
    public SquareType getSquareType(int column, int row) { return poly[column][row]; }

}

