package group_a.tennis;

public class TennisGame {
    Player player1 = new Player();
    Player player2 = new Player();

    public TennisGame(String player1Name, String player2Name) {
        player1.setName(player1Name);
        player2.setName(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1"){
            player1.addPoint();
        }else {
            player2.addPoint();
        }
    }

    public String getScore() {
        String score = "";
        if (deuce()) {
            score = getDeuceMessage(score);
        } else if (player1.getScore() >= 4 || player2.getScore() >= 4) {
            score = getWinMessage();
        } else {
            String scoreMessage = "";
            scoreMessage = getScoreMessage(player1.getScore());
            score += scoreMessage + "-";
            scoreMessage = getScoreMessage(player2.getScore());
            score += scoreMessage;
        }
        return score;
    }

    private String getDeuceMessage(String score) {
        if (player1.getScore() <= 2) {
            score += getScoreMessage(player2.getScore()) +"-All";
        }else {
            score = "Deuce";
        }
        return score;
    }

    private boolean deuce() {
        return player1.getScore() == player2.getScore();
    }

    private String getWinMessage() {
        String score;
        int minusResult = player1.getScore() - player2.getScore();
        if (minusResult == 1) score = "Advantage " + player1.getName();
        else if (minusResult == -1) score = "Advantage " + player2.getName();
        else if (minusResult >= 2) score = "Win for " + player1.getName();
        else score = "Win for " + player2.getName();
        return score;
    }

    private String getScoreMessage(int tempScore) {
        String score = "";
        switch (tempScore) {
            case 0:
                score = "Love";
                break;
            case 1:
                score = "Fifteen";
                break;
            case 2:
                score = "Thirty";
                break;
            case 3:
                score = "Forty";
                break;
        }
        return score;
    }
}
