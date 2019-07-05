import java.util.ArrayList;

public class TennisGame1 implements TennisGame {
    private int[] scores = {0, 0};
    private ArrayList<String> players;
    private String[] pointNames = {"Love", "Fifteen", "Thirty", "Forty"};

    TennisGame1(String player1, String player2) {
        players  = new ArrayList<String>();
        players.add(player1);
        players.add(player2);
    }

    public void wonPoint(String playerName) {
        scores[players.indexOf(playerName)]++;
    }

    public String getScores() {
        if (isDeuce()) {
            return "Deuce";
        } else if (scoresAreEqual()) {
            return getEqualScore();
        } else if (isAtEndGame()) {
            return getEndGameScore();
        } else {
            return getGameScore();
        }
    }

    private boolean scoresAreEqual() {
        return scores[0] == scores[1];
    }

    private boolean isAtEndGame() {
        return scores[0] >= 4 || scores[1] >= 4;
    }

    private boolean isDeuce() {
        return (scoresAreEqual() && scores[0] >= 3);
    }

    private boolean isAdvantage() {
        return Math.abs(scores[0] - scores[1]) == 1;
    }

    private String getGameScore() {
        return pointNames[scores[0]] + "-" + pointNames[scores[1]];
    }

    private String getEqualScore() {
        return  pointNames[scores[0]] + "-All";
    }

    private String getEndGameScore() {
        if (isAdvantage()) return "Advantage " + getWinningPlayer();
        else return "Win for " + getWinningPlayer();
    }

    private String getWinningPlayer() {
        if (scores[0] > scores[1]) return players.get(0);
        else return players.get(1);
    }
}
