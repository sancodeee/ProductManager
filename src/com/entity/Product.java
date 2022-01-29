package com.entity;

import java.io.Serializable;

public class Product  implements Serializable {
    private  Integer productId;
    private  String productName;
    private  Double price;
    private  Integer inventory;
    private  String description;

    public Product() {
    }

    public Product(String productName, Double price, Integer inventory, String description) {
        this.productName = productName;
        this.price = price;
        this.inventory = inventory;
        this.description = description;
    }

    public Product(Integer productId, String productName, Double price, Integer inventory, String description) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.inventory = inventory;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
