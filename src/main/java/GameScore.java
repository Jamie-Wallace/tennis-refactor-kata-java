public class GameScore extends ScoreType {
    public String getScore(int player1Points, int player2Points) {
         return pointNames[player1Points] + "-" + pointNames[player2Points];
    }
}
