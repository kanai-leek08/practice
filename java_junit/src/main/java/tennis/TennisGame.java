package tennis;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (m_score1 == m_score2) {
            score = sameScoreLabel();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = judgeDuce() + judgeWinner();
        } else {
            score += scoreToCallLabel(m_score1) + "-" + scoreToCallLabel(m_score2);
        }
        return score;
    }

    private String sameScoreLabel() {
        switch (m_score1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private String judgeWinner() {
        if (m_score1 > m_score2) return this.player1Name;
        else return this.player2Name;
    }

    private String judgeDuce() {
        if (Math.abs(m_score1 - m_score2) == 1) return "Advantage ";
        else return "Win for ";
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
}
