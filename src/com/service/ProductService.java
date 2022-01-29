package com.service;

import com.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> listProducts();
    List<Product> listProducts(String productName,String operation ,double price,int pageNum,int pageSize);

    int totalRows(String productName,String operation ,double price);

    //根据id删除
    public void removeProduct(Integer id);
    //添加
    public void saveProduct(Product product);
    //更新
    public  void updateProduct(Product product);

    Product getProductById(Integer id);







}
