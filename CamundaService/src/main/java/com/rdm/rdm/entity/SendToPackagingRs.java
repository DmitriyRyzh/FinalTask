package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class SendToPackagingRs {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SendToPackagingRs() {
    }

    public SendToPackagingRs(String status) {
        this.status = status;
    }
}
