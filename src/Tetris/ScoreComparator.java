package Tetris;

import java.util.Comparator;

/**
 * Class that creates an object that compares two HighScore objects.
 */
public class ScoreComparator implements Comparator<Highscore>
{
    /**
     * Function that compares the two given Highscore objects given.
     * @param player1 Highscore object
     * @param player2 Highscore object
     * @return "-1" whether the first is smaller then the seoncd; "0" if both are equal; "1" if the first one is the biggest.
     */
    public int compare(Highscore player1, Highscore player2) {
	return Integer.compare(player2.getScore(), player1.getScore());
    }
}
