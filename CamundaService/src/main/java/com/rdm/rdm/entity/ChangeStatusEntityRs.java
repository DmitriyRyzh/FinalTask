package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class ChangeStatusEntityRs {
    private String isSuccess;

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public ChangeStatusEntityRs() {
    }

    public ChangeStatusEntityRs(String isSuccess) {
        this.isSuccess = isSuccess;
    }
}
