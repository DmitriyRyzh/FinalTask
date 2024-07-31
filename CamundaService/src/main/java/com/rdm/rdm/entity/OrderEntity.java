package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@JsonAutoDetect
public class OrderEntity implements Serializable {

    private Long Id;
    private String address;
    private String clientname;
    private Set<ItemEntity> items = new HashSet<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public Set<ItemEntity> getItems() {
        return items;
    }

    public void setItems(Set<ItemEntity> items) {
        this.items = items;
    }

    public OrderEntity() {
    }

    public OrderEntity(Long id, String address, String clientname, Set<ItemEntity> items) {
        Id = id;
        this.address = address;
        this.clientname = clientname;
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "Id=" + Id +
                ", address='" + address + '\'' +
                ", clientname='" + clientname + '\'' +
                ", items=" + items +
                '}';
    }
}
