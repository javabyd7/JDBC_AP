package pl.sda.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeService {

    public void printAllEmployees() {
        try {
            Connection connection = DBConnector.getConnection();
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

    public void addEmployee() {
        System.out.println("podaj employeeNumber,lastName,firstName,extension,email,officeCode,reportsTo,jobTitle");
        String[] params = new Scanner(System.in).nextLine().split(",");
        if (params.length == 8) {
            try {
                Connection connection = DBConnector.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("insert  into employees(employeeNumber,lastName,firstName,extension,email,officeCode,reportsTo,jobTitle)" +
                        " values (?,?,?,?,?,?,?,?)");
                preparedStatement.setInt(1, Integer.parseInt(params[0]));
                preparedStatement.setString(2, params[1]);
                preparedStatement.setString(3, params[2]);
                preparedStatement.setString(4, params[3]);
                preparedStatement.setString(5, params[4]);
                preparedStatement.setString(6, params[5]);
                preparedStatement.setInt(7, Integer.parseInt(params[6]));
                preparedStatement.setString(8, params[7]);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
