public class TennisGame {
    private int player1Point;
    private int player2Point;

    private final String player1Name;
    private final String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() throws Exception {
        String player1Result;
        String player2Result;
        String score;
        if (player1Point == player2Point && player1Point < 3) {
            score = getWordFromScore(player1Point);
            score += "-All";
        } else if (player1Point == player2Point)
            score = "Deuce";
        else if (player1Point >= 4 && (player1Point - player2Point) == 1) {
            score = "Advantage player1";
        } else if (player2Point >= 4 && (player2Point - player1Point) == 1) {
            score = "Advantage player2";
        } else if (player1Point >= 4 && (player1Point - player2Point) >= 2) {
            score = "Win for player1";
        } else if (player2Point >= 4 && (player2Point - player1Point) >= 2) {
            score = "Win for player2";
        } else {
            player1Result = getWordFromScore(player1Point);
            player2Result = getWordFromScore(player2Point);
            score = player1Result + "-" + player2Result;
        }
        return score;
    }

    public void p1Score() {
        player1Point++;
    }

    public void p2Score() {
        player2Point++;
    }

    public void wonPoint(String player) {
        if (player.equals("player1"))
            p1Score();
        else
            p2Score();
    }

    private String getWordFromScore(int score) throws Exception {
        String word;
        switch (score) {
            case 0:
                word = "Love";
                break;
            case 1:
                word = "Fifteen";
                break;
            case 2:
                word = "Thirty";
                break;
            case 3:
                word = "Forty";
                break;
            default:
                throw new Exception("Invalid input for getWordFromScore");
        }
        return word;
    }


}
