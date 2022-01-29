package com.dao.impl;

import com.dao.ProductDao;
import com.entity.Product;
import com.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public void insertProduct(Product product) {
        Connection conn=null;
        PreparedStatement pstm=null;
        try {
            conn = JDBCUtils.getConnection();
            //3 准备一个发送SQL的工具
            String sql = "insert into t_product values (null ,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,product.getProductName());
            pstm.setDouble(2,product.getPrice());
            pstm.setInt(3,product.getInventory());
            pstm.setString(4,product.getDescription());
            //4 发送并执行SQL
            pstm.executeUpdate();
            //5 处理结果集
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //6 释放资源
            JDBCUtils.close(null,pstm,null);
        }

    }


    @Override
    public void deleteProductById(Integer id) {
        Connection conn=null;
        PreparedStatement pstm=null;
        try {
            conn= JDBCUtils.getConnection();
            //3 准备一个发送SQL的工具
            String sql = "delete from t_product where productId=? ";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,id);
            //4 发送并执行SQL
            pstm.executeUpdate();
            //5 处理结果集
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(null,pstm,null);
        }

    }

    @Override
    public void updateProduct(Product product) {
        Connection conn=null;
        PreparedStatement pstm=null;
        try{
            conn=JDBCUtils.getConnection();
            //3 准备一个发送SQL的工具
            String sql = "update t_product set productName=?,price=?,inventory=?,description=? where productId=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,product.getProductName());
            pstm.setDouble(2,product.getPrice());
            pstm.setInt(3,product.getInventory());
            pstm.setString(4,product.getDescription());
            pstm.setInt(5,product.getProductId());
            //4 发送并执行SQL
            pstm.executeUpdate();
            //5 处理结果集
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //6 释放资源
            JDBCUtils.close(null, pstm, null);
        }

    }

    @Override
    public Product selectProductById(Integer id) {
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        Product product=null;
        try {
            conn =JDBCUtils.getConnection();
            //3 准备一个发送SQL的工具
            String sql = "select * from t_product where productId=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,id);
            //4 发送并执行SQL
            rs = pstm.executeQuery();
            //5 处理结果集
            if(rs.next()) {
                //rs.getXxx(列顺序从1开始) 或者 rs.getXxx("列名") 获取指定列的数据，Xxx为数据类型  实战中多使用列名，可读性强
                int productId = rs.getInt("productId");
                String productName = rs.getString("productName");
                double price = rs.getDouble("price");
                int inventory = rs.getInt("inventory");
                String description = rs.getString("description");
                product = new Product(productId, productName, price, inventory, description);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //6 释放资源
            JDBCUtils.close(null,pstm,rs);
        }
        return product;
    }

    @Override
    public List<Product> selectProducts() {

        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        List<Product> products= new ArrayList<>();
        try {
            conn =JDBCUtils.getConnection();
            //3 准备一个发送SQL的工具
            String sql = "select * from t_product";
            pstm = conn.prepareStatement(sql);
            //4 发送并执行SQL
            rs = pstm.executeQuery();
            //5 处理结果集
            while (rs.next()) {
                //rs.getXxx(列顺序从1开始) 或者 rs.getXxx("列名") 获取指定列的数据，Xxx为数据类型  实战中多使用列名，可读性强

                int productId = rs.getInt("productId");
                String productName = rs.getString("productName");
                double price = rs.getDouble("price");
                int inventory = rs.getInt("inventory");
                String description = rs.getString("description");
                Product product = new Product(productId, productName, price, inventory, description);
                products.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //6 释放资源
            JDBCUtils.close(null,pstm,rs);
        }
        return products;
    }

    @Override
    public List<Product> selectProducts(String productName,String operation ,double price,int offset, int rows) {
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        List<Product> products= new ArrayList<>();
        try {
            conn =JDBCUtils.getConnection();
            //3 准备一个发送SQL的工具
            String sql = "select * from t_product  where productName like concat('%',?,'%') and price "+operation+" ? limit ?,?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,productName);
            pstm.setDouble(2,price);
            pstm.setInt(3,offset);
            pstm.setInt(4,rows );
            //4 发送并执行SQL
            rs = pstm.executeQuery();
            //5 处理结果集
            while (rs.next()) {
                //rs.getXxx(列顺序从1开始) 或者 rs.getXxx("列名") 获取指定列的数据，Xxx为数据类型  实战中多使用列名，可读性强

                int productId = rs.getInt("productId");
                String productName2 = rs.getString("productName");
                double price2 = rs.getDouble("price");
                int inventory = rs.getInt("inventory");
                String description = rs.getString("description");
                Product product = new Product(productId, productName2, price2, inventory, description);
                products.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //6 释放资源
            JDBCUtils.close(null,pstm,rs);
        }
        return products;
    }



    @Override
    public int totalRows(String productName,String operation ,double price) {
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        int rows=0;
        try {
            conn =JDBCUtils.getConnection();
            //3 准备一个发送SQL的工具
            String sql = "select count(*) from t_product where productName like concat('%',?,'%') and price "+operation+" ? ";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,productName);
            pstm.setDouble(2,price);
            //4 发送并执行SQL
            rs = pstm.executeQuery();
            //5 处理结果集
            if (rs.next()) {
                 rows = rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //6 释放资源
            JDBCUtils.close(null,pstm,rs);
        }
        return rows;
    }
}
