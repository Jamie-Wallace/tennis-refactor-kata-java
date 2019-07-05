package GameScores;

public class EqualScore extends ScoreType {
    private int player1Points;

    public EqualScore(int player1Points) {
        this.player1Points = player1Points;
    }

    public String getScore() {
        return  pointNames[player1Points] + "-All";
    }
}

