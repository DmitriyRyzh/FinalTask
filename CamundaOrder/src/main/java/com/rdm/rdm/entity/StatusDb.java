package com.rdm.rdm.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Table(schema = "camundaorders", name = "status")
public class StatusDb implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "statuscode")
    private String statusCode;

    @Column(name = "statusname")
    private String statusName;

    public StatusDb(Long id, String statusCode, String statusName) {
        this.id = id;
        this.statusCode = statusCode;
        this.statusName = statusName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatuscode() {
        return statusCode;
    }

    public void setStatuscode(String statuscode) {
        this.statusCode = statuscode;
    }

    public String getStatusname() {
        return statusName;
    }

    public void setStatusname(String statusname) {
        this.statusName = statusname;
    }
}
