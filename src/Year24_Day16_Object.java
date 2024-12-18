import java.util.ArrayList;
import java.util.HashSet;

public class Year24_Day16_Object {

    private int score;
    private int direction;
    private String previousKey;
    private HashSet<String> possiblePaths;

    public Year24_Day16_Object(int score, int direction, String previousKey, HashSet<String> possiblePaths) {
        this.score = score;
        this.direction = direction;
        this.previousKey = previousKey;
        this.possiblePaths = possiblePaths;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getPreviousKey() {
        return previousKey;
    }

    public void setPreviousKey(String previousKey) {
        this.previousKey = previousKey;
    }

    public HashSet<String> getPossiblePaths() {
        return possiblePaths;
    }

    public void setPossiblePaths(HashSet<String> possiblePaths) {
        this.possiblePaths = possiblePaths;
    }
}
