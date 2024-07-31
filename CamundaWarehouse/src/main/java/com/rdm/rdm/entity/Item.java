package com.rdm.rdm.entity;

public class Item {

    private String code;
    private Double quantity;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Item() {
    }

    public Item(String code, Double quantity) {
        this.code = code;
        this.quantity = quantity;
    }
}
