package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class SendToServiceRsEntity {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SendToServiceRsEntity() {
    }

    public SendToServiceRsEntity(String status) {
        this.status = status;
    }
}
