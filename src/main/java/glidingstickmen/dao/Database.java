package glidingstickmen.dao;

import java.sql.*;

/**
 * a class for getting a connection to database or creating a database if it doesn't exist
 * 
 */
public class Database {
    Connection conn;
    
    /**
     * getting a connection to database or creating a database if it doesn't exist
     * 
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public Database() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        
        this.conn = DriverManager.getConnection("jdbc:sqlite:scores.db");
        
        
        PreparedStatement stmt1 = conn.prepareStatement("SELECT COUNT(*) AS number FROM sqlite_master WHERE type='table'");
        ResultSet rs = stmt1.executeQuery();
        rs.next();
        int tables = rs.getInt("number");
        if (tables == 0) {
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
        
    }
    
    public Connection getConnection() throws SQLException {        
        return conn;
    }
}
