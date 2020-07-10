package com.jdbc;

import java.sql.*;

public class ProductsDAO {
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

    public String sql_findall = "select * FROM products";
    public String sql_findbyid = "SELECT * FROM products WHERE id = ?";
    public String sql_insert = "INSERT INTO products VALUES (?, ?, ?)";
    public String sql_update = "UPDATE products SET name = ?, price = ? WHERE id = ?";
    public String sql_delete = "DELETE FROM products WHERE id = ?";

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driverName);
            return DriverManager.getConnection(URL, login, password);
        }
        catch (ClassNotFoundException ex) {
            System.err.println("Error: " + ex);
            return null;
        }
        catch (SQLException ex) {
            System.err.println("Error: " + ex);
            return null;
        }
    }

    public void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Error: " + ex);
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        ProductsDAO app = new ProductsDAO();
        app.getConnection();
    }

}
