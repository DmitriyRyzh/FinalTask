package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class SendOrderRsEntity {
    private String isSuccess;

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public SendOrderRsEntity() {
    }

    public SendOrderRsEntity(String isSuccess) {
        this.isSuccess = isSuccess;
    }
}