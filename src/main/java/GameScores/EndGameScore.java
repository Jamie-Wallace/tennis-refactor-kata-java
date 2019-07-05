package GameScores;

public class EndGameScore extends ScoreType {
    private final TennisPlayer player1;
    private final TennisPlayer player2;

    EndGameScore(TennisPlayer player1, TennisPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {
        if (isAdvantage()) return "Advantage " + getWinningPlayer();
        else return "Win for " + getWinningPlayer();
    }

    private boolean isAdvantage() {
        return Math.abs(player1.score - player2.score) == 1;
    }

    private String getWinningPlayer() {
        if (player1.score > player2.score) return player1.name;
        else return player2.name;
    }
}
