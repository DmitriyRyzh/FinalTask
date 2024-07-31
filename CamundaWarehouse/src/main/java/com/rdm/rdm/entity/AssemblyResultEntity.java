package com.rdm.rdm.entity;

public class AssemblyResultEntity {

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

    public AssemblyResultEntity() {
    }

    public AssemblyResultEntity(Long id, String isSuccess) {
        this.id = id;
        this.isSuccess = isSuccess;
    }
}
