package group_c.tennis;

public class TennisGame {
    private String player1Name;
    private String player2Name;
    private Judge judge;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        judge = new Judge();
    }

    public void wonPoint(String playerName) {
        judge.wonPoint(playerName);
    }

    public String getScore() {
        String score = "";
        if (judge.isSamePoint()) {
            score = getScoreSamePoint();
        } else if (judge.isAdvantage()) {
            score = getScoreAdvantage();
        } else {
            score = getScoreDifferentPoint();
        }
        return score;
    }

    private String getScoreDifferentPoint() {
        return getScoreCall(judge.m_score1) + "-" + getScoreCall(judge.m_score2);
    }

    private String getScoreCall(int tempScore) {
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

    private String getScoreAdvantage() {
        String score;

        int minusResult = judge.getScoreDifference();
        if (minusResult == 1) score = "Advantage " + this.player1Name;
        else if (minusResult == -1) score = "Advantage " + this.player2Name;
        else if (minusResult >= 2) score = "Win for " + this.player1Name;
        else score = "Win for " + player2Name;
        return score;
    }

    private String getScoreSamePoint() {
        String score;

        switch (judge.m_score1) {
            case 0:
            case 1:
            case 2:
                score = getScoreCall(judge.m_score1) + "-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }


}
