import GameScores.*;

import java.util.ArrayList;

public class TennisGame1 implements TennisGame {
    private int[] scores = {0, 0};
    private ArrayList<String> players;

    TennisGame1(String player1, String player2) {
        players = new ArrayList<String>();
        players.add(player1);
        players.add(player2);
    }

    public void wonPoint(String playerName) {
        scores[players.indexOf(playerName)]++;
    }

    public String getScores() {
        ScoreType scoreType;
        if (isDeuce()) {
            scoreType = new DeuceScore();
        } else if (scoresAreEqual()) {
            scoreType = new EqualScore();
        } else if (isAtEndGame()) {
            scoreType = new EndGameScore(players.get(0), players.get(1));
        } else {
            scoreType = new GameScore();
        }
        return scoreType.getScore(scores[0], scores[1]);
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
}
