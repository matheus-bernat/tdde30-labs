package Tetris;

import java.util.ArrayList;
import java.util.List;

/**
 * Class tha representes the list of scores in the game collected. It has methods to
 * add scores to the list, show all the scores in the list.
 */
final public class HighscoreList {

    private static final HighscoreList INSTANCE = new HighscoreList();
    private List<Highscore> listOfScores;

    private HighscoreList() {
        listOfScores = new ArrayList<>();
    }

    /**
     * Getter that returns the created Singleton object "INSTANCE".
     * @return HighScoreList object INSTANCE
     */
    public static HighscoreList getInstance() {
        return INSTANCE;
    }

    /**
     * Adds a Highscore object to the list we created in here "listOfScores"
     * @param score Highscore object
     */
    public void addToScoreList(Highscore score) {
        listOfScores.add(score);
    }

    /**
     * Goes through all the Highscore elements in the list and print them in decreasing order of points.
     */
    public void showAllScores() {
        ScoreComparator comparatorObject = new ScoreComparator();
        listOfScores.sort(comparatorObject);
        System.out.println("\n\n\n\n\n##### HIGHEST SCORES #####\n");
        int position = 0;
        for (Highscore score: listOfScores) {
            position++;
            System.out.println(position + ". " + score.getName() + ": " + score.getScore());
        }
    }
}
