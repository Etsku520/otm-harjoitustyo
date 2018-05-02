package glidingstickmen.dao;

/**
* Score is a class for keeping the information about a score. 
* It represent the table the in database.
*/
public class Score {
    private String player1;
    private String player2;
    private int score1;
    private int score2;
    
    /**
    * Score is a class for keeping the information about a score. 
    * It represent the table the in database.
    *
    * @param player1, name of player 1
    * @param player2, name of player 2
    * @param score1, the amount of rounds player 1 won
    * @param score2, the amount of rounds player 2 won
    */
    public Score(String player1, String player2, int score1, int score2) {
        this.player1 = player1;
        this.player2 = player2;
        this.score1 = score1;
        this.score2 = score2;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        
        Score s = (Score) obj;
        if (s.getPlayer1().equals(this.getPlayer1()) 
                && s.getPlayer2().equals(this.getPlayer2())
                && s.score1 == this.score1
                && s.score2 == this.score2) {
            return true;
        }
        
        return false;
    }
    
    
}
