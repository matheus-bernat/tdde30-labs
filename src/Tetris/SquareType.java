package Tetris;

/**
 * Enum class of SquareTypes.
 */
public enum SquareType

{
    EMPTY, I, O, T, S, Z, J, L, OUTSIDE; /* We keep the names like this even though they are too short.
                                            It doesn't make any difference any way, and it's easier to represent.*/
                                         /* Won't add Javadoc for each one of the types since I consider it unnecessary */


    /**
     * Getter function that returns how many enum types there are, minus one (in order to avoid problems since we
     * don't want to take OUTSIDE type into consideration on other functions).
     * @return intger representing the length of the EnumTypes minus 1.
     */
    public static int getLength() {
	return SquareType.values().length - 1;     /* Returns (length-1) to avoid problems with OUTSIDE in the switch statements in other classes*/

        }
}

