package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DataHelper {
    private static final String DBPathConnection = "jdbc:sqlite:database//db_PoliSalud.sqlite"; 
    
    private Connection conn = null;
    
    protected DataHelper() { }
    
    protected synchronized Connection openConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(DBPathConnection);
        }
        return conn;
    }

    protected void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
