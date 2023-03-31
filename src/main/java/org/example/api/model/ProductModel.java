package org.example.api.model;

import org.example.jooq.tables.pojos.TbProduct;

import java.math.BigDecimal;

public class ProductModel {

    //TODO:: We shouldn't expose Database IDs in this way to the API.
    //There should be an encrypt/decrypt library
    Integer id;
    String name;
    BigDecimal price;

    public ProductModel(Integer id, String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public ProductModel(TbProduct product) {
        this.id = product.getProductId();
        this.name = product.getProductName();
        this.price = product.getProductPrice();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
