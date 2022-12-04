package com.example.messengerclient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDao {

    // credentials
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/ChatApp";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "07242209";
    private static final String SELECT_QUERY = "SELECT * FROM user WHERE login = ? and password = ?";

    public boolean validate(String loginID, String password) throws SQLException {
        // // Step 1: Establishing a Connection and
        // // try-with-resource statement will auto close the connection.
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager
                    .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            if (conn != null) {
                System.out.println("Connected to the database successfully!");
            }
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
            preparedStatement.setString(1, loginID);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}