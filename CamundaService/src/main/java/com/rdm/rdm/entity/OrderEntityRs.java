package com.rdm.rdm.entity;

public class OrderEntityRs {
    private String isSuccess;

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public OrderEntityRs() {
    }

    public OrderEntityRs(String isSuccess) {
        this.isSuccess = isSuccess;
    }
}