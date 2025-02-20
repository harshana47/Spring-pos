package org.example.z13_spring_boot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item {
    @Id
    private int id;
    private String name;
    private String description;
    private int qty;
    private double price;

    // One item can be in many order details
    @OneToMany(mappedBy = "item")
    private List<OrderDetails> orderDetails;
}
