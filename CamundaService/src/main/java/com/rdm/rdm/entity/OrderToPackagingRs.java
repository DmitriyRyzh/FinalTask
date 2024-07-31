package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class OrderToPackagingRs {
    private String isSuccess;

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public OrderToPackagingRs() {
    }

    public OrderToPackagingRs(String isSuccess) {
        this.isSuccess = isSuccess;
    }
}
