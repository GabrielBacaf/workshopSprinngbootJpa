package com.projectWebServices.project.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.util.Set;
import java.io.Serializable;

import java.time.Instant;
import java.util.HashSet;


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
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrdemItem> items = new HashSet<>();


    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;



    public Order(){}

    public Order(Long id, Instant moment, OrderStatus orderStatus ,User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Instant getMoment() {return moment;}

    public void setMoment(Instant moment) {this.moment = moment;}

    public User getClient() {return client;}

   public final Set<OrdemItem> getItems(){return items;}

    public Payment getPayment() {return payment;}

    public void setPayment(Payment payment) {this.payment = payment;}


    public OrderStatus getOrderStatus() {return OrderStatus.valueOf(orderStatus);}

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {this.orderStatus = orderStatus.getCodigo();}

    }

    public void setClient(User client) {
        this.client = client;
    }

    double sum = 0.0;
    public Double getTotal(){
        for(OrdemItem somaOrder : items){  sum += somaOrder.getSubTotal();}
        return sum;
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
