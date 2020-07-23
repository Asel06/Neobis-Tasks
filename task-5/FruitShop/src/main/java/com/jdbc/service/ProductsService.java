package com.jdbc.service;

import com.jdbc.dao.ProductsDAO;
import com.jdbc.entity.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsService implements ProductsDAO{
    ProductsDAO productsDAO;
    private Connection connection;

    public void getConnect() throws ClassNotFoundException, SQLException {
        String driverName = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/FruitShop?allowPublicKeyRetrieval=TRUE"+
                "&verifyServerCertificate=false"+
                "&useSSL=false"+
                "&requireSSL=false"+
                "&useLegacyDatetimeCode=false"+
                "&amp"+
                "&serverTimezone=UTC";
        String login = "root";
        String password = "raspberries0";
        Class.forName(driverName);
        connection = DriverManager.getConnection(URL, login, password);
    }
    public List<Products> findAll() {
        try {
            PreparedStatement statement = connection.prepareStatement(productsDAO.sql_findall);
            ResultSet resultSet = statement.executeQuery();
            List<Products> products = new ArrayList<Products>();
            while (resultSet.next()) {
                 Products product = new Products();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getInt("price"));

                products.add(product);
            }
            resultSet.close();
            connection.close();
            return products;
        } catch (SQLException ex) {
            System.out.println("Can't get connection");
            ex.printStackTrace();
            return null;
        }
    }

}
