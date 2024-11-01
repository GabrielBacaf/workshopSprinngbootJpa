package com.projectWebServices.project.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT-3")
    private Instant moment;

        private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private User cliente;

    public Order(){

    }

    public Order(Long id, Instant moment, OrderStatus orderStatus ,User cliente) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getCliente() {
        return cliente;
    }

    public OrderStatus getOrderStatus() {return OrderStatus.valueOf(orderStatus);}

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus == null) {this.orderStatus = orderStatus.getCode();}

    }

    public void setCliente(User cliente) {
        this.cliente = cliente;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;

        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
