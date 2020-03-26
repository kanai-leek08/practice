package tennis;

public class TennisGame {

    private Player player1;
    private Player player2;
    private Judge judge;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        judge = new Judge(player1, player2);

    }

    public void wonPoint(String playerName) {
        if (playerName == player1.name) {
            player1.won();
        } else
            player2.won();
    }

    public String getScore() {
        String score;

        if (judge.isSameScore()) {
            score = sameScoreLabel();
        } else if (judge.isDuce()) {
            score = duceLabel() + judgeWinner();
        } else {
            score = scoreToCallLabel(player1.score) + "-" + scoreToCallLabel(player2.score);
        }
        return score;
    }

    private String sameScoreLabel() {
        if (player1.isNotGamePoint()) {
            return scoreToCallLabel(player1.score) + "-All";
        } else {
            return "Deuce";
        }
    }

    private String judgeWinner() {

        return  (player1.score > player2.score) ? player1.name : player2.name;
    }

    private String duceLabel() {
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
        public String name;

        public Player(String name) {
            this.name = name;
        }

        private void won() {
            score += 1;
        }

        private boolean isNotGamePoint() {
            return score == 0
                || score == 1
                || score == 2;
        }
    }

    private class Judge {
        private final Player player1;
        private final Player player2;

        public Judge(Player player1, Player player2) {

            this.player1 = player1;
            this.player2 = player2;
        }

        public boolean isDuce() {
            return player1.score >= 4 || player2.score >= 4;
        }

        public boolean isSameScore() {
            return player1.score == player2.score;
        }
    }
}
