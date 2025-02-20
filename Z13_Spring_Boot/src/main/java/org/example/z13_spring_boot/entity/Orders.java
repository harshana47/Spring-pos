package org.example.z13_spring_boot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate orderDate;
    private double totalAmount;

    // Many orders belong to one customer
    @ManyToOne
    @JoinColumn(name = "customer_id") // Foreign key in the orders table
    private Customer customer;

    // One order can have many order details
    @OneToMany(mappedBy = "orders")
    private List<OrderDetails> orderDetails;
}
