package org.example.z13_spring_boot.entity;

import jakarta.persistence.*;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;
    private double total;

    // Many order details belong to one order
    @ManyToOne
    @JoinColumn(name = "order_id") // Foreign key in the order_details table
    private Orders orders;

    // Many order details can have one item
    @ManyToOne
    @JoinColumn(name = "item_id") // Foreign key in the order_details table
    private Item item;
}
