import GameScores.*;

public class TennisGame1 implements TennisGame {
    private final TennisPlayer player1;
    private final TennisPlayer player2;

    TennisGame1() {
        player1 = new TennisPlayer("player1");
        player2 = new TennisPlayer("player2");
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
