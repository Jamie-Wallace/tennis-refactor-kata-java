import GameScores.*;

public class TennisGame1 implements TennisGame {
    private TennisPlayer player1;
    private TennisPlayer player2;

    TennisGame1(String player1Name, String player2Name) {
        player1 = new TennisPlayer(player1Name);
        player2 = new TennisPlayer(player2Name);
    }

    public void wonPoint(String playerName) {
        if (player1.name.equals(playerName)) player1.score++;
        else player2.score++;
    }

    public String getScores() {
        ScoreType scoreType;
        if (isDeuce()) {
            scoreType = new DeuceScore();
        } else if (scoresAreEqual()) {
            scoreType = new EqualScore(player1.score);
        } else if (isAtEndGame()) {
            scoreType = new EndGameScore(player1.score, player2.score, player1.name, player2.name);
        } else {
            scoreType = new GameScore(player1.score, player2.score);
        }
        return scoreType.getScore();
    }

    private boolean scoresAreEqual() {
        return player1.score == player2.score;
    }

    private boolean isAtEndGame() {
        return player1.score >= 4 || player2.score >= 4;
    }

    private boolean isDeuce() {
        return (scoresAreEqual() && player1.score >= 3);
    }
}
