public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;

    TennisGame1() {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        StringBuilder score;
        if (m_score1==m_score2)
        {
            score = getEqualScore();
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            score = getEndGameScore();
        }
        else
        {
            score = getGameScore();
        }
        return score.toString();
    }

    private StringBuilder getGameScore() {
        StringBuilder score = new StringBuilder();
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = m_score1;
            else { score.append("-"); tempScore = m_score2;}
            switch(tempScore)
            {
                case 0:
                    score.append("Love");
                    break;
                case 1:
                    score.append("Fifteen");
                    break;
                case 2:
                    score.append("Thirty");
                    break;
                case 3:
                    score.append("Forty");
                    break;
            }
        }
        return score;
    }

    private StringBuilder getEndGameScore() {
        StringBuilder score;
        int minusResult = m_score1-m_score2;
        if (minusResult==1) score = new StringBuilder("Advantage player1");
        else if (minusResult ==-1) score = new StringBuilder("Advantage player2");
        else if (minusResult>=2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score;
    }

    private StringBuilder getEqualScore() {
        StringBuilder score;
        switch (m_score1)
        {
            case 0:
                    score = new StringBuilder("Love-All");
                break;
            case 1:
                    score = new StringBuilder("Fifteen-All");
                break;
            case 2:
                    score = new StringBuilder("Thirty-All");
                break;
            default:
                    score = new StringBuilder("Deuce");
                break;

        }
        return score;
    }
}
