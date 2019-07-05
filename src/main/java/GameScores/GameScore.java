package GameScores;

public class GameScore extends ScoreType {
    private int player1Points;
    private int player2Points;

    public GameScore(int player1Points, int player2Points) {
        this.player1Points = player1Points;
        this.player2Points = player2Points;
    }

    public String getScore() {
         return pointNames[player1Points] + "-" + pointNames[player2Points];
    }
}
