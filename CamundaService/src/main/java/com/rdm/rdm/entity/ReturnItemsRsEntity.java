package com.rdm.rdm.entity;

public class ReturnItemsRsEntity {
    private String isSuccess;

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public ReturnItemsRsEntity() {
    }

    public ReturnItemsRsEntity(String isSuccess) {
        this.isSuccess = isSuccess;
    }
}
