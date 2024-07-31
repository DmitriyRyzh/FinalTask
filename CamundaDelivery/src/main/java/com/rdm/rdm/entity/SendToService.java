package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class SendToService {
    private Long id;
    private String isSuccess;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public SendToService() {
    }

    public SendToService(String isSuccess, Long id) {
        this.isSuccess = isSuccess;
        this.id = id;
    }

    @Override
    public String toString() {
        return "SendToService{" +
                "id=" + id +
                ", isSuccess='" + isSuccess + '\'' +
                '}';
    }
}
