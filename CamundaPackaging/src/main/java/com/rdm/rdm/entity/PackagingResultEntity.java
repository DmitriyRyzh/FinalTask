package com.rdm.rdm.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class PackagingResultEntity {

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

    public PackagingResultEntity() {
    }

    public PackagingResultEntity(Long id, String isSuccess) {
        this.id = id;
        this.isSuccess = isSuccess;
    }
}
