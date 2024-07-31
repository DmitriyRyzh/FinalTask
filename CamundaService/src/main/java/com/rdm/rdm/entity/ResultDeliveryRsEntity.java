package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class ResultDeliveryRsEntity {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResultDeliveryRsEntity() {
    }

    public ResultDeliveryRsEntity(String status) {
        this.status = status;
    }
}
