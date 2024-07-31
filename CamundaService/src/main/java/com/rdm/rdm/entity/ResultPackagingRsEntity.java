package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class ResultPackagingRsEntity {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResultPackagingRsEntity() {
    }

    public ResultPackagingRsEntity(String status) {
        this.status = status;
    }
}
