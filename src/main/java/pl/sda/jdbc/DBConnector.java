package pl.sda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static final String ADDRESS = "jdbc:mysql://127.0.0.1";
    private static final String DATABASE = "employee_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String PORT = "3306";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String PARAMS = "serverTimezone=UTC";
    private static Connection connection = null;

    private static String getFormattedURL() {
        return ADDRESS + ":" + PORT + "/" + DATABASE + "?" + PARAMS;
    }

    private static void loadDriver() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void DBConnector() {
        loadDriver();
        try {
            connection = DriverManager.getConnection(getFormattedURL(), USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            DBConnector();
        }
        return connection;
    }
}