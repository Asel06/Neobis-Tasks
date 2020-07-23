package com.jdbc;

import com.jdbc.service.ProductsService;

import java.sql.*;

public class Main {


    public static void main(String[] args){
        ProductsService productsService = new ProductsService();
        productsService.findAll();
    }

}
