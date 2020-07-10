package com.jdbc.service;

import com.jdbc.entity.Products;
import com.jdbc.ProductsDAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductsService {
    ProductsDAO productsDAO;

    public List<Products> findAll() throws SQLException{
        List<Products> products = new ArrayList<Products>();
        Connection con = productsDAO.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(productsDAO.sql_findall);
        productsDAO.closeConnection(con);
        return products;
    }

    public Products findByID(int id) throws SQLException{
        Products products = null;
        Connection con = productsDAO.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(productsDAO.sql_findbyid);
        preparedStatement.setInt(1, products.getId());
        productsDAO.closeConnection(con);
        return products;
    }

    public void insert(Products products) throws SQLException {
        Connection con = productsDAO.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(productsDAO.sql_insert);
        preparedStatement.setInt(1, products.getId());
        preparedStatement.setString(2, products.getName());
        preparedStatement.setInt(3, products.getPrice());
        preparedStatement.execute();
        productsDAO.closeConnection(con);
    }

    public void update(Products products) throws SQLException{
        Connection con = productsDAO.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(productsDAO.sql_update);
        preparedStatement.setString(1, products.getName());
        preparedStatement.setInt(2, products.getPrice());
        preparedStatement.setInt(3, products.getId());
        preparedStatement.execute();
        productsDAO.closeConnection(con);
    }

    public void delete(Products products) throws SQLException{
        Connection con = productsDAO.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(productsDAO.sql_delete);
        preparedStatement.setInt(1, products.getId());
        preparedStatement.execute();
        productsDAO.closeConnection(con);
    }
}
