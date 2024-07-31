package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class ReceiveFromPackagingRs {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ReceiveFromPackagingRs() {
    }

    public ReceiveFromPackagingRs(String status) {
        this.status = status;
    }
}
