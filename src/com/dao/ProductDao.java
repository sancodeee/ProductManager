package com.dao;

import com.entity.Product;

import java.util.List;

public interface ProductDao {

    void insertProduct(Product product);
    void deleteProductById(Integer id);
    void updateProduct(Product product);
    Product selectProductById(Integer id);
    List<Product> selectProducts();

    List<Product> selectProducts(String productName,String operation ,double price,int offset,int rows);

    int totalRows(String productName,String operation ,double price);//查询总条数










}
