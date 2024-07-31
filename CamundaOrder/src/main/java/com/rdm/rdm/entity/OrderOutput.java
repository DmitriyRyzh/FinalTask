package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//@JsonAutoDetect
//@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderOutput implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long Id;
    private String address;
    private String clientname;
    private Set<ItemInput> items = new HashSet<ItemInput>();

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
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

    public OrderOutput() {
    }

    public OrderOutput(Long Id, String address, String clientname, Set<ItemInput> items) {
        this.Id = Id;
        this.address = address;
        this.clientname = clientname;
        this.items = items;
    }

    @Override
        public String toString() {
            return "OrderOutput{" +
                    "Id=" + Id +
                    ", address='" + address + '\'' +
                    ", clientname='" + clientname + '\'' +
                    ", items=" + items +
                    '}';
    }

}
