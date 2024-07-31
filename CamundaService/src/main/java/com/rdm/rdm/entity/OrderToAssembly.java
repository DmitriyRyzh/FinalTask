package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.HashSet;
import java.util.Set;

@JsonAutoDetect
public class OrderToAssembly {

    private Long id;
    private Set<Item> items = new HashSet<Item>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderToAssembly() {
    }

    public OrderToAssembly(Long id, Set<Item> items) {
        this.id = id;
        this.items = items;
    }


    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

}
