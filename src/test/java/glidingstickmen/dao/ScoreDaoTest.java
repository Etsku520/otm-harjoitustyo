package glidingstickmen.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ScoreDaoTest {
    Connection conn;
    ScoreDao sd;
    
    public ScoreDaoTest() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        
        this.conn = DriverManager.getConnection("jdbc:sqlite:testScores.db");
        
        
        PreparedStatement stmt1 = conn.prepareStatement("SELECT COUNT(*) AS number FROM sqlite_master WHERE type='table'");
        ResultSet rs = stmt1.executeQuery();
        rs.next();
        int tables = rs.getInt("number");
        if(tables == 0) {
            PreparedStatement stmt = conn.prepareStatement("CREATE TABLE Score "
                    + "(id INTEGER NOT NULL, "
                    + "player1 varchar(100), "
                    + "player2 varchar(100), "
                    + "score1 INTEGER, "
                    + "score2 INTEGER, "
                    + "PRIMARY KEY (id))");

            stmt.executeUpdate();
            stmt.close();
        }
        sd = new ScoreDao(conn);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM Score WHERE id = id");
        stmt.executeUpdate();
        stmt.close();
    }

    @Test
    public void addingScore() throws SQLException {
        Score score = new Score("p1", "p2", 1, 3);
        
        sd.addScore(score);
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Score "
                + "WHERE player1 = (?) AND player2 = (?) AND score1 = (?) AND score2 = (?)");
        stmt.setString(1, score.getPlayer1());
        stmt.setString(2, score.getPlayer2());
        stmt.setInt(3, score.getScore1());
        stmt.setInt(4, score.getScore2());
        
        ResultSet rs = stmt.executeQuery();
        ArrayList<Score> scores = new ArrayList<>();
        while (rs.next()) {
            scores.add(new Score(rs.getString("player1"), rs.getString("player2"), rs.getInt("score1"), rs.getInt("score2")));
        }

        rs.close();
        stmt.close();
        
        assertEquals(true, scores.contains(score));
        
        for (int i = 0; i < 11; i++) {
            Score score2 = new Score("p1", "p2", i, i+1);
            sd.addScore(score);
        }
        
        ArrayList<Score> scores2 = sd.getScores();
        
        assertEquals(10, scores2.size());
    }
    
}
