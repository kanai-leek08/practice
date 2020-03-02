package group_a.tennis;

public class Player {

    private String playerName;
    private int player1_score;

    public int getScore() {
        return this.player1_score;
    }

    public void setName(String playerName) {
        this.playerName = playerName;
    }

    public void setScore(int player1_score) {

        this.player1_score = player1_score;
    }

    public String getName() {
        return this.playerName;
    }

    void addPoint() {
        this.player1_score++;
    }
}
