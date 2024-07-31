package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

@JsonAutoDetect
public class ItemEntity implements Serializable {


    private String code;
    private Double quantity;

    public ItemEntity() {
    }

    public ItemEntity(String code, Double quantity) {
        this.code = code;
        this.quantity = quantity;
    }

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

    @Override
    public String toString() {
        return "ItemInput{" +
                "code='" + code + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
