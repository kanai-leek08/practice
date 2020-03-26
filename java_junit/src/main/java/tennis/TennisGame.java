package tennis;

public class TennisGame {
    
    private String player1Name;
    private String player2Name;
    private Player player1;
    private Player player2;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1.score += 1;
        else
            player2.score += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (player1.score == player2.score) {
            score = sameScoreLabel();
        } else if (player1.score >= 4 || player2.score >= 4) {
            score = judgeDuce() + judgeWinner();
        } else {
            score = scoreToCallLabel(player1.score) + "-" + scoreToCallLabel(player2.score);
        }
        return score;
    }

    private String sameScoreLabel() {
        switch (player1.score) {
            case 0:
            case 1:
            case 2:
                return scoreToCallLabel(player1.score) + "-All";
            default:
                return "Deuce";
        }
    }

    private String judgeWinner() {
        return  (player1.score > player2.score) ? this.player1Name : this.player2Name;
    }

    private String judgeDuce() {
        return (Math.abs(player1.score - player2.score) == 1) ? "Advantage " : "Win for ";
    }

    private String scoreToCallLabel(int tempScore) {
        switch (tempScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "";
    }

    private class Player {
        public int score = 0;

        public Player(String name) {

        }
    }
}
