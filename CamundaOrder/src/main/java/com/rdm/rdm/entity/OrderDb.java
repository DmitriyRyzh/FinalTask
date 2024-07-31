package com.rdm.rdm.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(schema = "camundaorders", name = "order")
public class OrderDb {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "statuscode",referencedColumnName="statuscode")
    @ManyToOne(fetch = FetchType.LAZY)
    private StatusDb statusDb;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "address")
    private String address;

    @Column(name = "clientname")
    private String clientname;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderid")
    private Set<ItemDb> items;

    public OrderDb(Long id, StatusDb statusDb, LocalDateTime date, String address, String clientname, Set<ItemDb> items) {
        this.id = id;
        this.statusDb = statusDb;
        this.date = date;
        this.address = address;
        this.clientname = clientname;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusDb getStatusDb() {
        return statusDb;
    }

    public void setStatusDb(StatusDb statusDb) {
        this.statusDb = statusDb;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public Set<ItemDb> getItems() {
        return items;
    }

    public void setItems(Set<ItemDb> items) {
        this.items = items;
    }
}
