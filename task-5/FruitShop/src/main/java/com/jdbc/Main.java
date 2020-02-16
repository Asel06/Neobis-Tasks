package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Main {
    private final String driverName = "com.mysql.cj.jdbc.Driver";
    private final String login = "root";
    private final String password = "raspberries0";
    private final String URL = "jdbc:mysql://localhost:3306/FruitShop"+
            "?verifyServerCertificate=false"+
            "&useSSL=false"+
            "&requireSSL=false"+
            "&useLegacyDatetimeCode=false"+
            "&amp"+
            "&serverTimezone=UTC";;
    Connection connection = null;

    public void run() {
        try {
            Class.forName(driverName);
        }
        catch (ClassNotFoundException ex) {
            System.out.println("Can't get class. No driver found");
            ex.printStackTrace();
            return;
        }
        try {
            connection = DriverManager.getConnection (URL, login, password);
            System.out.println("good");
        }
        catch (SQLException ex) {
            System.out.println("Can't get connection. Incorrect URL");
            ex.printStackTrace();
            return;
        }
        try {
            connection.close();
        }
        catch (SQLException ex) {
            System.out.println("Can't close connection");
            ex.printStackTrace();
            return;
        }
    }
    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

}