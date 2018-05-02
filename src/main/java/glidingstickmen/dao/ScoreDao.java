package glidingstickmen.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * It's a class used for adding scores to database and getting scores from database
 */
public class ScoreDao {
    Connection conn;
    
    /**
     * It's a class used for adding scores to database and getting scores from database
     * 
     * @param conn  Connection to the database
     */
    public ScoreDao(Connection conn) {
        this.conn = conn;
    }
    
    /**
     * As the name says, the method is used for adding a score to database
     * 
     * @param score         The score that will be added
     * @throws SQLException 
     */
    public void addScore(Score score) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Score (player1, player2, score1, score2) VALUES (?, ? , ?, ?)");
        stmt.setString(1, score.getPlayer1());
        stmt.setString(2, score.getPlayer2());
        stmt.setInt(3, score.getScore1());
        stmt.setInt(4, score.getScore2());
        
        stmt.executeUpdate();
        stmt.close();
    }
    
    /**
     * Gets scores from database in a list.
     * 
     * @return ten latest scores from database
     * @throws SQLException 
     */
    public ArrayList<Score> getScores() throws SQLException {
        ArrayList<Score> scores = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Score ORDER BY id DESC LIMIT 10");
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            scores.add(new Score(rs.getString("player1"), rs.getString("player2"), 
                    rs.getInt("score1"), rs.getInt("score2")));
        }
        
        stmt.close();
        rs.close();
        
        return scores;
    }
}
