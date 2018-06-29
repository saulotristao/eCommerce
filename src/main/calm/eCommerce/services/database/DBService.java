package main.calm.eCommerce.services.database;

import java.sql.*;
import java.util.Scanner;

public class DBService {

    public DBService() {
    }

    // You need to close the resultSet
    public void close(PreparedStatement preparedStatement1, Connection connection1) {
        try {

            if (preparedStatement1 != null) {
                preparedStatement1.close();
            }

            if (connection1 != null) {
                connection1.close();
            }
        } catch (Exception e) {

        }
    }
    public void close(Statement statement1, Connection connection1) {
        try {

            if (statement1 != null) {
                statement1.close();
            }

            if (connection1 != null) {
                connection1.close();
            }
        } catch (Exception e) {

        }
    }


    // You need to close the resultSet
    public void close(ResultSet resultSet1, Statement statement1, Connection connection1) {
        try {
            if (resultSet1 != null) {
                resultSet1.close();
            }
            if (statement1 != null) {
                statement1.close();
            }

            if (connection1 != null) {
                connection1.close();
            }
        } catch (Exception e) {

        }
    }
    // method to create a connection

    public Connection getConnection(){

        Connection responseConnection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            responseConnection = DriverManager.getConnection("jdbc:mysql://localhost/eCommerce?" +
                    "user=root&password=&useSSL=false&serverTimezone=UTC");

        }catch (Exception e){
            e.getStackTrace();
        }
        return responseConnection;
    }

    public int checkIfingteger(String a){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (a.length () == 1) {
                try {
                    return Integer.parseInt (a);
                }
                catch (NumberFormatException e) {
                    // do nothing.
                }
            }
            System.out.println ("Error!(" + a + ") Please enter a single digit. ");
            a = scanner.nextLine ();
        }
    }

}

