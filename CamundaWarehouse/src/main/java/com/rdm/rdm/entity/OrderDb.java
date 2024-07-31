package com.rdm.rdm.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(schema = "camundawarehouse", name = "order")
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


    @Column(name = "serviceid")
    private Long serviceId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderid")
    private Set<OrderItemDb> items = new HashSet<OrderItemDb>();



    public OrderDb(Long id, StatusDb statusDb, LocalDateTime date, Set<OrderItemDb> items, Long serviceId) {
        this.id = id;
        this.statusDb = statusDb;
        this.date = date;
        this.items = items;
        this.serviceId = serviceId;
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

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Set<OrderItemDb> getItems() {
        return items;
    }

    public void setItems(Set<OrderItemDb> items) {
        this.items = items;
    }
}
