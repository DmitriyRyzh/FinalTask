package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Set;

@JsonAutoDetect
public class ReturnItemsEntity {
    private Set<Item> items;
    private Long orderId;

    public Long getOrderID() {
        return orderId;
    }

    public void setOrderID(Long orderId) {
        this.orderId = orderId;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public ReturnItemsEntity() {
    }

    public ReturnItemsEntity(Set<Item> items, Long orderId) {
        this.items = items;
        this.orderId = orderId;
    }
}
