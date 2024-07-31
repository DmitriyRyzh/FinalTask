package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class OrderToDelivery {

    private String address;
    private String clientname;
    private Long orderId;

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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderToDelivery() {
    }

    public OrderToDelivery(String address, String clientname, Long orderId) {
        this.address = address;
        this.clientname = clientname;
        this.orderId = orderId;
    }
}
