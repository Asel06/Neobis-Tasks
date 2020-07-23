package com.jdbc.dao;

import com.jdbc.entity.Products;

import java.sql.SQLException;
import java.util.List;

public interface ProductsDAO {
    public String sql_findall = "select * FROM products";
    public String sql_findbyid = "SELECT * FROM products WHERE id = ?";
    public String sql_insert = "INSERT INTO products VALUES (?, ?, ?)";
    public String sql_update = "UPDATE products SET name = ?, price = ? WHERE id = ?";
    public String sql_delete = "DELETE FROM products WHERE id = ?";

    public List<Products> findAll() throws SQLException;

}
