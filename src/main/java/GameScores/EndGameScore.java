package GameScores;

public class EndGameScore extends ScoreType {
    private String player1;
    private String player2;

    public EndGameScore(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore(int player1Points, int player2Points) {
        if (isAdvantage(player1Points, player2Points)) return "Advantage " + getWinningPlayer(player1Points, player2Points);
        else return "Win for " + getWinningPlayer(player1Points, player2Points);
    }

    private boolean isAdvantage(int player1Points, int player2Points) {
        return Math.abs(player1Points - player2Points) == 1;
    }

    private String getWinningPlayer(int player1Points, int player2Points) {
        if (player1Points > player2Points) return player1;
        else return player2;
    }
}
