package GameScores;

public abstract class ScoreType {
    protected String[] pointNames = {"Love", "Fifteen", "Thirty", "Forty"};

    public abstract String getScore();
}
