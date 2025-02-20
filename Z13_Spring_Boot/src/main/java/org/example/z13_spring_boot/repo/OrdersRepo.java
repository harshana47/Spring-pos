package org.example.z13_spring_boot.repo;

import org.example.z13_spring_boot.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Orders, Integer> {
}
