package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class SendToServiceRs {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SendToServiceRs() {
    }

    public SendToServiceRs(String status) {
        this.status = status;
    }
}
