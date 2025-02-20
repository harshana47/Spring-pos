package org.example.z13_spring_boot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    private int id;
    private String name;
    private String address;

    // One customer can have many orders
    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;
}
