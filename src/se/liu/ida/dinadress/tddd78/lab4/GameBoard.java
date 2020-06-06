package se.liu.ida.dinadress.tddd78.lab4;

public class GameBoard
{
    // ENUM TYPE
    private enum CellType
    {
        EMPTY(false), TREE(true), BUILDING(true), ROCK(true), POWERUP(false), BORDER(true);

        public final boolean isObstacle;

       CellType(final boolean isObstacle) { //vad gör denna rad?
            this.isObstacle = isObstacle;
	}
    }

    // ENUM TYPE
    public enum Move {
        DOWN(0, 1), UP(0, -1), RIGHT(1, 0), LEFT(-1, 0);

        public final int deltaX;
        public final int deltaY;

        Move(final int deltaX, final int deltaY) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }
    }

    // FIELDS
    private CellType[][] cells;
    private int currentX, currentY;

    // CONSTRUCTOR
    public GameBoard(int width, int height) {
        this.cells = new CellType[height][width];
        this.currentX = width / 2;
        this.currentY = height / 2;
    }

    // MOVE
    public void move(Move move) {
        if (canMove(move)) {
            currentX += move.deltaX;
            currentY += move.deltaY;
        }
    }

    // MOVE CHECKER
    public boolean canMove(Move move) {
        return !cells[currentY + move.deltaX][currentX + move.deltaY].isObstacle;
        }
}
