package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class OrderToDeliveryRs {
    private String isSuccess;

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String status) {
        this.isSuccess = isSuccess;
    }

    public OrderToDeliveryRs() {
    }

    public OrderToDeliveryRs(String isSuccess) {
        this.isSuccess = isSuccess;
    }
}
