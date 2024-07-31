package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class OrderToAssemblyRs {
    private String isSuccess;

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public OrderToAssemblyRs() {
    }

    public OrderToAssemblyRs(String isSuccess) {
        this.isSuccess = isSuccess;
    }
}
