package com.jdbc;

import java.sql.*;

public class Main {
    private final String driverName = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/FruitShop?allowPublicKeyRetrieval=TRUE"+
            "&verifyServerCertificate=false"+
            "&useSSL=false"+
            "&requireSSL=false"+
            "&useLegacyDatetimeCode=false"+
            "&amp"+
            "&serverTimezone=UTC";
    private final String login = "root";
    private final String password = "raspberries0";

    public void run() {
        Connection connection = null;

        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection (URL, login, password);
            Statement statement = connection.createStatement();
            //Выводим значения
            ResultSet resultSet = statement.executeQuery("select * from products");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) +" "+ resultSet.getInt(3));
            }
            //Добавить запись
            statement.executeUpdate("INSERT INTO products values (2, 'Palm', 68)");
            //Обновить запись
            statement.executeUpdate("UPDATE products SET name = 'Apple' where id = 4");
            //Удаляем запись
            statement.executeUpdate("DELETE FROM products where id = 4");

            ResultSet res = statement.executeQuery("select * from products");
            while (res.next()) {
                System.out.println(res.getString(2) +" "+ res.getInt(3));
            }
            connection.close();
        }

        catch (SQLException ex) {
            ex.printStackTrace();
        }

        catch (ClassNotFoundException ex) {
            System.out.println("Can't get class. No driver found");
            ex.printStackTrace();
            return;
        }

    }
    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

}