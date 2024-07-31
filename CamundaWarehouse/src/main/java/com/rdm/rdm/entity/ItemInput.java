package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class ItemInput {

    private String code;
    private Double quantity;

    public ItemInput() {
    }

    public ItemInput(String code, Double quantity) {
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
