package GameScores;

public class ScoreTypeFactory {
    private TennisPlayer player1;
    private TennisPlayer player2;

    public ScoreTypeFactory(TennisPlayer player1, TennisPlayer player2)
    {
        this.player1 = player1;
        this.player2 = player2;
    }

    public ScoreType getScoreType() {
        ScoreType scoreType;
        if (isDeuce()) {
            scoreType = new DeuceScore();
        } else if (scoresAreEqual()) {
            scoreType = new EqualScore(player1);
        } else if (isAtEndGame()) {
            scoreType = new EndGameScore(player1, player2);
        } else {
            scoreType = new GameScore(player1, player2);
        }
        return scoreType;
    }

    private boolean scoresAreEqual() {
        return player1.score == player2.score;
    }

    private boolean isAtEndGame() {
        return player1.score >= 4 || player2.score >= 4;
    }

    private boolean isDeuce() {
        return (scoresAreEqual() && player1.score >= 3);
    }
}
