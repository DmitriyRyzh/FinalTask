package com.rdm.rdm.entity;

public class ChangeStatusEntity {

    private Long id;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String isSuccess) {
        this.status = status;
    }

    public ChangeStatusEntity() {
    }

    public ChangeStatusEntity(Long id, String status) {
        this.id = id;
        this.status = status;
    }
}
