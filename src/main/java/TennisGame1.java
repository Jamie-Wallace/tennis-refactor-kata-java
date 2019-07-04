public class TennisGame1 implements TennisGame {
    private int[] scores = {0,0};

    TennisGame1() {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            scores[0]++;
        else
            scores[1]++;
    }

    public String getScores() {
        StringBuilder score;
        if (scoresAreEqual()) {
            score = getEqualScore();
        } else if (atEndGame()) {
            score = getEndGameScore();
        } else {
            score = getGameScore();
        }
        return score.toString();
    }

    private boolean atEndGame() {
        return scores[0] >= 4 || scores[1] >= 4;
    }

    private boolean scoresAreEqual() {
        return scores[0] == scores[1];
    }

    private StringBuilder getGameScore() {
        StringBuilder score = new StringBuilder();
        int tempScore;
        for (int i = 0; i < 2; i++) {
            tempScore = scores[i];
            if (i == 1) score.append("-");
            switch (tempScore) {
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
        int minusResult = scores[0] - scores[1];
        if (minusResult == 1) score = new StringBuilder("Advantage player1");
        else if (minusResult == -1) score = new StringBuilder("Advantage player2");
        else if (minusResult >= 2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score;
    }

    private StringBuilder getEqualScore() {
        StringBuilder score;
        switch (scores[0]) {
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
