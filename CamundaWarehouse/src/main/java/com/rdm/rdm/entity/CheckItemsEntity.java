package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Set;

@JsonAutoDetect
public class CheckItemsEntity {
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

    public CheckItemsEntity() {
    }

    public CheckItemsEntity(Set<Item> items, Long orderId) {
        this.items = items;
        this.orderId = orderId;
    }
}
