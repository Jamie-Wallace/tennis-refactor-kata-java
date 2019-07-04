public class TennisGame1 implements TennisGame {
    private int[] scores = {0, 0};
    private String[] pointNames = {"Love", "Fifteen", "Thirty", "Forty"};

    TennisGame1() {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            scores[0]++;
        else
            scores[1]++;
    }

    public String getScores() {
        String score;
        if (isDeuce()) {
            score = "Deuce";
        } else if (scoresAreEqual()) {
            score = getEqualScore();
        } else if (atEndGame()) {
            score = getEndGameScore();
        } else {
            score = getGameScore();
        }
        return score;
    }

    private boolean atEndGame() {
        return scores[0] >= 4 || scores[1] >= 4;
    }

    private boolean scoresAreEqual() {
        return scores[0] == scores[1];
    }

    private boolean isDeuce() {
        return (scoresAreEqual() && scores[0] == 4);
    }

    private String getGameScore() {
        return pointNames[scores[0]] + "-" + pointNames[scores[1]];
    }

    private String getEndGameScore() {
        int minusResult = scores[0] - scores[1];
        if (minusResult == 1) return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2) return "Win for player1";
        else return "Win for player2";
    }

    private String getEqualScore() {
        switch (scores[0]) {
            case 0:
                return "Love-All";
            case 1:
                return  "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }
}
