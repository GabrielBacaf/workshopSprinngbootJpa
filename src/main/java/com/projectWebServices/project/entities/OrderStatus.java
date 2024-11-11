package com.projectWebServices.project.entities;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int codigo;

    private OrderStatus(int codigo){this.codigo = codigo;}
    public int getCodigo(){return codigo;}

    public  static OrderStatus valueOf(int codigo){for (OrderStatus value : values()) {if (value.getCodigo() == codigo) return value;}
        throw new IllegalArgumentException("Invalid OrderStatus code");
        }
}

