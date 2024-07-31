package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.rdm.rdm.entity.ItemDb;
import com.rdm.rdm.entity.StatusDb;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@JsonAutoDetect
public class OrderInput {

    private String address;
    private String clientname;
    private Set<ItemInput> items = new HashSet<ItemInput>();

    public OrderInput() {
    }

    public OrderInput(String address, String clientname, Set<ItemInput> items) {
        this.address = address;
        this.clientname = clientname;
        this.items = items;
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

    public Set<ItemInput> getItems() {
        return items;
    }

    public void setItems(Set<ItemInput> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderInput{" +
                "address='" + address + '\'' +
                ", clientname='" + clientname + '\'' +
                ", items=" + items.toString() +
                '}';
    }
}
