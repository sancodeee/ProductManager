package com.entity;

import java.io.Serializable;

public class CartItem implements Serializable {
    private Product product;//用来记录商品信息
    private Integer size;//用来记录购物数量


    public CartItem() {
    }

    public CartItem(Product product, Integer size) {
        this.product = product;
        this.size = size;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", size=" + size +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
