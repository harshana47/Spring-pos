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

    public OrderDetails() {
    }

    public OrderDetails(int id, int quantity, double total, Orders orders, Item item) {
        this.id = id;
        this.quantity = quantity;
        this.total = total;
        this.orders = orders;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
