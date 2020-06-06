package Tetris;

/**
 * Class representing a score. It saves the number of points and the name of the player.
 */
public class Highscore
{
    private int score;
    private String name;

    /**
     * Constructor of the Highscore objects.
     * @param score integer representing how many points a player has scored.
     * @param name string representing the points the player got.
     */
    public Highscore(final int score, final String name) {
	this.score = score;
	this.name = name;
    }

    /**
     * Getter that returns the private field "score".
     * @return int score
     */
    public int getScore() {
	return score;
    }

    /**
     * Getter that returns the private field "name".
     * @return String name
     */
    public String getName() {
	return name;
    }
}
