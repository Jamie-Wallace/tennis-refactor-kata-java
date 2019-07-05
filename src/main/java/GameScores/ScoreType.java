package GameScores;

public abstract class ScoreType {
    final String[] pointNames = {"Love", "Fifteen", "Thirty", "Forty"};

    public abstract String getScore();
}
