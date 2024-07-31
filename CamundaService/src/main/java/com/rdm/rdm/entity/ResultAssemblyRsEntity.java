package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class ResultAssemblyRsEntity {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResultAssemblyRsEntity() {
    }

    public ResultAssemblyRsEntity(String status) {
        this.status = status;
    }
}
