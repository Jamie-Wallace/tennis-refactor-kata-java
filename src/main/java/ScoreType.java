public abstract class ScoreType {
    protected String[] pointNames = {"Love", "Fifteen", "Thirty", "Forty"};

    abstract String getScore(int player1Points, int player2Points);
}
