package com.service.impl;

import com.dao.ProductDao;
import com.dao.impl.ProductDaoImpl;
import com.entity.Product;
import com.service.ProductService;
import com.util.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private   ProductDaoImpl productDao = new ProductDaoImpl();

    @Override
    public List<Product> listProducts() {
        Connection conn = JDBCUtils.getConnection();
        List<Product> products=null;
        try {
            conn.setAutoCommit(false);
            products = productDao.selectProducts();

            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(conn,null,null);
        }
        return products;
    }

    @Override
    public List<Product> listProducts(String productName,String operation ,double price,int pageNum, int pageSize) {
        Connection conn = JDBCUtils.getConnection();
        List<Product> products=null;
        try {
            conn.setAutoCommit(false);
            int offset=(pageNum-1)*pageSize;
            int rows=pageSize;
            products = productDao.selectProducts(productName,operation,price,offset,rows);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(conn,null,null);
        }
        return products;
    }


    @Override
    public int totalRows(String productName,String operation ,double price) {
        Connection conn = JDBCUtils.getConnection();
        int rows=0;
        try {
            conn.setAutoCommit(false);
            rows = productDao.totalRows(productName,operation ,price);
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(conn,null,null);
        }
        return rows;
    }

    @Override
    public void removeProduct(Integer id) {
        Connection conn= JDBCUtils.getConnection();
        try{
            conn.setAutoCommit(false);
            productDao.deleteProductById(id);
            conn.commit();
        }catch (Exception e){
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(conn,null,null);
        }

    }

    @Override
    public void saveProduct(Product product) {
        Connection conn= JDBCUtils.getConnection();
        try{
            conn.setAutoCommit(false);
            productDao.insertProduct(product);
            conn.commit();
        }catch (Exception e){
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(conn,null,null);
        }

    }

    @Override
    public void updateProduct(Product product) {
        Connection conn= JDBCUtils.getConnection();
        try{
            conn.setAutoCommit(false);
            productDao.updateProduct(product);
            conn.commit();
        }catch (Exception e){
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(conn,null,null);
        }

    }


    @Override
    public Product getProductById(Integer id) {
        Connection conn= JDBCUtils.getConnection();
        Product p=null;
        try{
            conn.setAutoCommit(false);
            p=productDao.selectProductById(id);
            conn.commit();
        }catch (Exception e){
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(conn,null,null);
        }
        return p;
    }
}
