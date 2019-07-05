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
        ScoreTypeFactory scoreFactory = new ScoreTypeFactory(player1, player2);
        ScoreType scoreType = scoreFactory.getScoreType();
        return scoreType.getScore();
    }
}
