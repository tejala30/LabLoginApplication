package com.prgmming;

import java.sql.Date;

/**
 * Created by tethippe on 3/23/2016.
 */
public class ProductEntity {
    private int prodId;
    private String prodName;
    private Date date;
    private String description;
    private int quantity;
    private int price;
    private int userId;

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        if (prodId != that.prodId) return false;
        if (quantity != that.quantity) return false;
        if (price != that.price) return false;
        if (userId != that.userId) return false;
        if (prodName != null ? !prodName.equals(that.prodName) : that.prodName != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prodId;
        result = 31 * result + (prodName != null ? prodName.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + price;
        result = 31 * result + userId;
        return result;
    }
}
