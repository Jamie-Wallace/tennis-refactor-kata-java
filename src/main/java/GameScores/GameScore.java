package GameScores;

public class GameScore extends ScoreType {
    private TennisPlayer player1;
    private TennisPlayer player2;

    public GameScore(TennisPlayer player1, TennisPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {
        return pointNames[player1.score] + "-" + pointNames[player2.score];
    }
}
