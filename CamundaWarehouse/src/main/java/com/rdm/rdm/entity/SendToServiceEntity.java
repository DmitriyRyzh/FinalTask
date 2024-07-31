package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

@JsonAutoDetect
public class SendToServiceEntity implements Serializable {
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

    public SendToServiceEntity() {
    }

    public SendToServiceEntity(String isSuccess, Long id) {
        this.isSuccess = isSuccess;
        this.id = id;
    }

    @Override
    public String toString() {
        return "SendToServiceEntity{" +
                "id=" + id +
                ", isSuccess='" + isSuccess + '\'' +
                '}';
    }
}
