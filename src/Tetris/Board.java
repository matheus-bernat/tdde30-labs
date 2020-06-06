package Tetris; /*We leave the name like that*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class that represents the playing field. It contains the information of the squares
 * inside it and has functionality to modify the square's position and so on.
 */
public class Board
{
    private SquareType[][] squares;
    private int width;
    private int height;
    final static int EXTRA_OUTSIDE_BLOCKS = 2;

    private Random random;

    private Poly falling = null;
    private int fallingX;
    private int fallingY;

    private int numberOfRowsRemoved;

    private boolean isGameOver;

    private List<BoardListener> listOfListeners = new ArrayList<>();

    private FallHandler fallHandler;

    /**
     * Constructor of the board object-
     * @param width integer representing the width of the board object
     * @param height integer representing the width of the board object
     */
    public Board(final int width, final int height) {
	this.width = width;
	this.height = height;
	this.random = new Random();
	this.fallingX = width/2 - 1;
	this.fallingY = 0;

	this.numberOfRowsRemoved = 0;
	this.isGameOver = false;
	this.fallHandler = new DefaultFallHandler();

	squares = new SquareType[width + 2 * EXTRA_OUTSIDE_BLOCKS][height + 2 * EXTRA_OUTSIDE_BLOCKS];

	createEmptyBoard();
    }

    /**
     * Creates a Board object with only EMPTY squares in it.
     */
    public void createEmptyBoard() {
	isGameOver = false;
	for (int column = 0; column < width + 2 * EXTRA_OUTSIDE_BLOCKS; column++) {
	    for (int row = 0; row < height + 2 * EXTRA_OUTSIDE_BLOCKS; row++) {
	        if (((row >= EXTRA_OUTSIDE_BLOCKS) && (row < height + EXTRA_OUTSIDE_BLOCKS)) &&
		    ((column >= EXTRA_OUTSIDE_BLOCKS) && (column < width + EXTRA_OUTSIDE_BLOCKS))) {
	            squares[column][row] = SquareType.EMPTY;
	        } else {
	            squares[column][row] = SquareType.OUTSIDE;
	        }
	    }
	}
    }

    /**
     * Function that returns the existant type of square in the given position.
     * The square might be either in the Board object, or in the falling one.
     */
    public SquareType getSquareAt(int column, int row) {

	if (falling == null) { return getSquareType(column, row); } /* I want to keep having identical if branches since
	                                                               I think it's clearer the way it is, with different cases*/

	/* Outside falling object*/
	else if (!(((row >= fallingY) && (row < fallingY + falling.getSize())) &&
		   ((column >= fallingX) && (column < fallingX + falling.getSize())))) {
	    return getSquareType(column, row);
	}
	/* Inside the falling object*/
	else if (((row >= fallingY) && (row < fallingY + falling.getSize())) && ((column >= fallingX) && (column < fallingX + falling.getSize()))) {
	    if (falling.getSquareType(column - fallingX, row - fallingY) == SquareType.EMPTY) { return getSquareType(column, row); } else {
		return falling.getSquareType(column - fallingX, row - fallingY);
	    }
	}

	throw new IndexOutOfBoundsException("Invalid index: " + "x = " + row + " y = " + column);
    }

    /**
     * Returns the existant type of square in the given position.
     * Looks only at the squares in the board.
     * @return type of square in position (column x row)
     */
    public SquareType getSquareType(int column, int row) {
    	return squares[column + EXTRA_OUTSIDE_BLOCKS][row + EXTRA_OUTSIDE_BLOCKS];
        }

    /**
     * Getter that returns the private field variable "height"
     * @return int height
     */
    public int getHeight() { return height; }

    /**
     * Getter that returns the private field variable "width"
     * @return int width
     */
    public int getWidth() { return width; }

    /**
    * Getter that returns the private field variable "getNumberOfRowsRemoved"
    * @return int numberOfRowsRemoved
    */
    public int getNumberOfRowsRemoved() {
	return numberOfRowsRemoved;
    }

    /**
     * Getter that returns the private field variable "fallingX"
     * @return int fallingX
     */
    public int getFallingX() { return fallingX; }

    /**
     * Getter that returns the private field variable "fallingY"
     * @return int fallingY
     */
    public int getFallingY() { return fallingY; }

    /**
      * Getter that returns the private field variable "falling"
      * @return Poly falling
      */
    public Poly getFalling() { return falling; }

    /**
      * Getter that returns the private field variable "fallHandler"
      * @return FallHandler fallHandler
      */
    public FallHandler getFallHandler() { return fallHandler; }

    /**
      * Getter that returns the private field variable "isGameOver"
      * @return boolean isGameOver
      */
    public boolean isIsGameOver() { return isGameOver; }

    /**
     * Sets a SquareType to a given position (column x row)
     * @param squareType type of square existant in the position (row x column)
     * @param column integer representing the column
     * @param row integer representing the row
     */
    public void setSquareType(SquareType squareType, int column, int row) {
	squares[column + EXTRA_OUTSIDE_BLOCKS][row + EXTRA_OUTSIDE_BLOCKS] = squareType;
    }

    /**
     * Adds board listeners to bl list.
     */
    public void addBoardListener(BoardListener bl) {
	listOfListeners.add(bl);
    }

    /**
     * Loops through all elements in the listener list and calls its boardChanged() methods.
     */
    private void notifyListeners() {
	for (BoardListener bl : listOfListeners) {
	    bl.boardChanged();
	}
    }

    /**
     * Makes the block move up a step.
     */
    public void moveUp() {
    	fallingY--;
        }

    /**
     * Makes the block move down a step.
     */
        public void moveDown() {
            fallingY++;
        }

    /**
     * Makes the block move right a step. It's asynchronous so it can be executed independently at any time.
     */
    public void moveRight() {
	fallingX++;
	if (fallHandler.hasCollision(this)) {
	    fallingX--;
	}
	notifyListeners();
    }

    /**
     * Makes the block move left a step. It's asynchronous so it can be executed independently at any time.
     */
    public void moveLeft() {
	fallingX--;
	if (fallHandler.hasCollision(this)) {
	    fallingX++;
	} /*hasCollision(..., movedDown = False)*/
	notifyListeners();
    }

    /**
     * Makes the block rotate right a step. It's asynchronous so it can be executed independently at any time.
     */
    public void rotateRight() {
	if (falling != null) {
	    SquareType[][] temporary = new SquareType[falling.getSize()][falling.getSize()];
	    for (int column = 0; column < temporary.length; column++) {
		for (int row = 0; row < temporary.length; row++) {
		    //temporary[column][falling.getSize()-1-row] = falling.getSquareType(row, column);
		    temporary[row][column] = falling.getSquareType(column, falling.getSize() - 1 - row);
		}
	    }
	    Poly originalFalling = falling;
	    falling = new Poly(temporary);
	    if (fallHandler.hasCollision(this)) { falling = originalFalling; }
	}
	notifyListeners();
    }

    /**
     * Makes the block rotate left a step by rotating 3 times right. It's asynchronous so it can be executed independently at any time.
     */
    public void rotateLeft() {
	if (falling != null) {
	    for (int i = 0; i < 3; i++) { rotateRight(); }
	}
	notifyListeners();
    }

    /**
     * Function that is called everytime from the timer. It loops a new falling object if there's none, and then m
     * makes the figures move down a step while checking whether there is a collision in the middle of it.
     * It changes even between the different types of fallHandlers,
     */
    public void tick() {
	if (!isGameOver) {
	    if (falling != null) {
		moveDown();
		if (fallHandler.hasCollision(this)) {
		    moveUp();
		    placeFallingInBoard();
		    checkRows();

		    falling = null; //
		    fallingX = width / 2 - 1;
		    fallingY = 0;

		    fallHandler = new DefaultFallHandler();
		}
	    }
	    else {
		int randomIndex = random.nextInt(SquareType.getLength() - 1) + 1;
		falling = TetrominoMaker.getPoly(randomIndex);

		if (numberOfRowsRemoved == 1) {
		    fallHandler = new Fallthrough(); }
		else if (numberOfRowsRemoved >= 2) { fallHandler = new Heavy(); }

		numberOfRowsRemoved = 0;


		if (fallHandler.hasCollision(this)) { isGameOver = true; falling = null; }
	    }
	    notifyListeners();
	}

    }

    /**
     * Goes though each of the falling object's components, and place them at the correspondant position in the board.
     */
    public void placeFallingInBoard() {
	for (int column = 0; column < falling.getSize(); column++) {
	    for (int row = 0; row < falling.getSize(); row++) {
		if (falling.getSquareType(column, row) == SquareType.EMPTY) {
		    setSquareType(getSquareType(column + fallingX,row + fallingY),column + fallingX,row + fallingY);
		} else {
		    setSquareType(falling.getSquareType(column, row),column + fallingX,row + fallingY);
		}
	    }
	}
    }

    /**
     * Checks whether the rows are empty. If they are, call another function removeRows() to remove them.
     */
    public void checkRows() {
	for (int row = 0; row < height; row++) {
	    boolean isRowFull = true;
	    for (int column = 0; column < width; column++) {
		isRowFull = isRowFull && (getSquareAt(column, row) != SquareType.EMPTY);
	    }
	    if (isRowFull) {
		numberOfRowsRemoved++;
	        removeRow(row); }
	}
	notifyListeners();
    }

    /**
     * Removes the rows assigned by the parameter unwantedRow.
     * @param unwantedRow integer representing the row that is to be removed.
     */
    public void removeRow(int unwantedRow) {
        for (int row = unwantedRow; row > 0; row--) {
            for (int column = 0; column < width; column++) {
                setSquareType(getSquareType(column, row-1), column, row);
	    }
	}
	for (int column = 0; column < width; column++) {
            setSquareType(SquareType.EMPTY, column, 0);
	}
    }

    /**
     * Presses down squares a step of the given columns
     */
    public void pressDownSquares(int pressedColumn, int collisionY) {
	int emptyRowSpot = 0;
	for (int row = collisionY + fallingY; row < height; row++) {
	    if (getSquareType(pressedColumn + fallingX, row) == SquareType.EMPTY) {
		emptyRowSpot = row;
		break;
	    }
	}
        for (int row = emptyRowSpot; row > fallingY; row--) {
	    setSquareType(getSquareType(pressedColumn + fallingX, row-1), pressedColumn + fallingX, row);
	}
    }
}