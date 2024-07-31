package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

@JsonAutoDetect
public class ResultDeliveryEntity implements Serializable {
    private Long id;
    private String isSuccess;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public ResultDeliveryEntity() {
    }

    public ResultDeliveryEntity(String isSuccess, Long id) {
        this.isSuccess = isSuccess;
        this.id = id;
    }
}
