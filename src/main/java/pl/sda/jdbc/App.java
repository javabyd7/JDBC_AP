package pl.sda.jdbc;

import java.sql.*;

public class App {

    public static void main(String[] args) {

        try (Connection connection = DBConnector.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM employee_db.employees;");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("employeeNumber") + " "
                        + resultSet.getString("lastName") + " "
                        + resultSet.getString("firstName") + " "
                        + resultSet.getString("extension") + " "
                        + resultSet.getString("email") + " "
                        + resultSet.getInt("officeCode") + " "
                        + resultSet.getInt("reportsTo") + " "
                        + resultSet.getString("jobTitle"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
