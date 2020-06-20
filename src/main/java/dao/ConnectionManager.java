package dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionManager.
 * Create connections to database for DAO objects.
 * @author Aydar_Safiullin
 */
public class ConnectionManager {
    private static final Logger logger = LogManager.getLogger("MainLogger");
    private static final String URL = "jdbc:postgresql://localhost:5432/ArcMetrology";
    private static final String USER = "postgres";
    private static final String PASSWORD = "qwerty";

    protected ConnectionManager() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            logger.error("Database connection error", e);
        }
        return connection;
    }

    protected JdbcRowSet getRowSet() {
        JdbcRowSet rowSet = null;
        try {
            rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl(URL);
            rowSet.setUsername(USER);
            rowSet.setPassword(PASSWORD);
        } catch (SQLException e) {
            logger.error("Database connection error", e);
        }
        return rowSet;
    }
}
