package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.HashSet;
import java.util.Set;

@JsonAutoDetect
public class OrderInput {

    private Long id;
    private Set<ItemInput> items = new HashSet<ItemInput>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderInput() {
    }

    public OrderInput(Long id, Set<ItemInput> items) {
        this.id = id;
        this.items = items;
    }


    public Set<ItemInput> getItems() {
        return items;
    }

    public void setItems(Set<ItemInput> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderInput{" +
                "id=" + id +
                ", items=" + items +
                '}';
    }
}
