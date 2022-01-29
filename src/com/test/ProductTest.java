package com.test;

import com.dao.UsersDao;
import com.dao.impl.ProductDaoImpl;
import com.dao.impl.UsersDaoImpl;
import com.entity.Product;
import jdk.nashorn.internal.ir.CallNode;
import org.junit.Test;

import java.util.List;

public class ProductTest {
    private ProductDaoImpl productDao = new ProductDaoImpl();
    @Test
    public  void  insert(){
        productDao.insertProduct(new Product());

    }
    @Test
    public void  delete(){

    }
    @Test
    public void update(){

    }
    @Test
    public void selectById(){


    }
    @Test
    public void selectByName(){


    }
    @Test
    public void selectAll(){
    }
}
