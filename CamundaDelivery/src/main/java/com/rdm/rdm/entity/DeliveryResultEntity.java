package com.rdm.rdm.entity;

import java.io.Serializable;

public class DeliveryResultEntity implements Serializable {

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

    public DeliveryResultEntity() {
    }

    public DeliveryResultEntity(Long id, String isSuccess) {
        this.id = id;
        this.isSuccess = isSuccess;
    }


}
