package group_c.tennis;

public class Judge {
    public int m_score1 = 0;
    public int m_score2 = 0;

    boolean isSamePoint() {
        return m_score1 == m_score2;
    }

    boolean isAdvantage() {
        return m_score1 >= 4 || m_score2 >= 4;
    }

    int getScoreDifference() {
        return m_score1 - m_score2;
    }

    void wonPoint(String playerName) {
        if (playerName == "player1") {
            m_score1 +=1;
        } else {
            m_score2 +=1;
        }
    }
}
