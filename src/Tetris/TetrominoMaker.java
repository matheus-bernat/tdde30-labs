package Tetris;

/**
 * Class that works as a factory of polys. It creates Poly objects and returns it
 * to the caller.
 */
final public class TetrominoMaker
{
    private TetrominoMaker() {}

    /**
     * Calls a function that creates the desired Poly object given by the integer/index n.
     * @param n integer that works as an index. It chooses which Poly that shall be created.
     * @return Poly object.
     */
    public static Poly getPoly(int n) {
	switch (n) {
	    case 0:
		break;
	    case 1:
		return createI();
	    case 2:
		return createO();
	    case 3:
		return createT();
	    case 4:
		return createS();
	    case 5:
		return createZ();
	    case 6:
		return createJ();
	    case 7:
		return createL();
	    default:
		throw new IllegalArgumentException("Invalid index: " + n);
	}
	throw new IllegalArgumentException("This won't work otherwise");
    }

    /**
     * Builds a new Poly I object and returns it.
     * @return Poly I object
     */
    public static Poly createI() {
	SquareType[][] polyI;
	polyI = new SquareType[4][4];
	for (int column = 0; column < 4; column++) {
	    for (int row = 0; row < 4; row++) {
	        if (row == 1) {
		    polyI[row][column] = SquareType.I;
		} else {
		    polyI[row][column] = SquareType.EMPTY;
		}
	    }
	}
	return new Poly(polyI);
    }

    /**
     * Builds a new Poly O object and returns it.
     * @return Poly O object
     */
    public static Poly createO() {
    	SquareType[][] polyO;
    	polyO = new SquareType[2][2];
    	for (int row = 0; row < 2; row++) {
	    for (int column = 0; column < 2; column++) {
		polyO[row][column] = SquareType.O;
	    }
	}
	return new Poly(polyO);
    }

    /**
     * Builds a new Poly Z object and returns it.
     * @return Poly Z object
     */
    public static Poly createT() {
    	SquareType[][] polyT;
    	polyT = new SquareType[3][3];
    	for (int column = 0; column < 3; column++) {
    	    for (int row = 0; row < 3; row++) {
    	        if ((row == 0) && (column == 1) || row == 1) {
    	            polyT[row][column] = SquareType.T;
    	        } else {
    	            polyT[row][column] = SquareType.EMPTY;
    	        }
    	    }
    	}
    	return new Poly(polyT);
    }

    /**
     * Builds a new Poly S object and returns it.
     * @return Poly S object
     */
    public static Poly createS() {
    	SquareType[][] polyS;
    	polyS = new SquareType[3][3];
    	for (int row = 0; row < 3; row++) {
    	    for (int column = 0; column < 3; column++) {
    	        if ((row == 0) && ((column == 1) || (column == 2)) || (row == 1) && ((column == 0) || (column == 1))) {
    	            polyS[row][column] = SquareType.S;
    	        } else {
    	            polyS[row][column] = SquareType.EMPTY;
    	        }
    	    }
    	}
    	return new Poly(polyS);
    }

    /**
     * Builds a new Poly Z object and returns it.
     * @return Poly Z object
     */
    public static Poly createZ() {
    	SquareType[][] polyZ;
    	polyZ = new SquareType[3][3];
    	for (int row = 0; row < 3; row++) {
    	    for (int column = 0; column < 3; column++) {
		if ((row == 1) && ((column == 1) || (column == 2)) || (row == 0) && ((column == 0) || (column == 1))) {
		    polyZ[row][column] = SquareType.Z;
		}
		else {
		    polyZ[row][column] = SquareType.EMPTY;
		}
    	    }
    	}
    	return new Poly(polyZ);
    }

    /**
     * Builds a new Poly J object and returns it.
     * @return Poly J object
     */
    public static Poly createJ() {
    	SquareType[][] polyJ;
    	polyJ = new SquareType[3][3];
    	for (int column = 0; column < 3; column++) {
    	    for (int row = 0; row < 3; row++) {
    	        if ((row == 0) && (column == 0) || row == 1) {
    	            polyJ[column][row] = SquareType.J;
    	        } else {
    	            polyJ[column][row] = SquareType.EMPTY;
    	        }
    	    }
    	}
    	return new Poly(polyJ);
    }

    /**
     * Builds a new Poly L object and returns it.
     * @return Poly L object
     */
    public static Poly createL() {
    	SquareType[][] polyL;
    	polyL = new SquareType[3][3];
    	for (int column = 0; column < 3; column++) {
    	    for (int row = 0; row < 3; row++) {
    	        if ((row == 0) && (column == 2) || row == 1) {
		    polyL[column][row] = SquareType.L;
		} else {
    	            polyL[column][row] = SquareType.EMPTY;
    	        }
    	    }
    	}
    	return new Poly(polyL);
    }
}

