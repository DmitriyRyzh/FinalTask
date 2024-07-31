package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class OrderToPackaging {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderToPackaging() {
    }

    public OrderToPackaging(Long id) {
        this.id = id;
    }
}
