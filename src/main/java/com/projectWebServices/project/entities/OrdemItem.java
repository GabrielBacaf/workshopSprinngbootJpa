package com.projectWebServices.project.entities;

import com.projectWebServices.project.entities.pk.OrdemItemPK;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;


@Entity
@Table(name = "tb_ordem_item")
public class OrdemItem implements Serializable {

    @EmbeddedId
    private OrdemItemPK id;
    private Integer quantity;
    private Double price;

    public OrdemItem () {}

    public OrdemItem (Order order, Product product ,Integer quantity, Double price) { this.quantity = quantity; this.price = price; id.setOrder(order); id.setProduct(product);}



    public Integer getQuantity() {return quantity;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    public Double getPrice() {return price;}

    public void setPrice(Double price) {this.price = price;}

    public Order getOder(){ return id.getOrder();}

    public void setOrder(Order order){ id.setOrder(order);}

    public Product getProduct(){ return id.getProduct();}

    public void setProduct(Product product){ id.setProduct(product);}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdemItem ordemItem = (OrdemItem) o;
        return id.equals(ordemItem.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
