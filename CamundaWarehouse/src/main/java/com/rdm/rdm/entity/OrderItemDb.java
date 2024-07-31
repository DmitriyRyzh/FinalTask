package com.rdm.rdm.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(schema = "camundawarehouse", name = "orderitem")
public class OrderItemDb {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "itemcode")
    private String itemCode;

    @Column(name = "quantity")
    private Double quantity;

    public OrderItemDb(Long id, String itemCode, Double quantity) {
        this.id = id;
        this.itemCode = itemCode;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
