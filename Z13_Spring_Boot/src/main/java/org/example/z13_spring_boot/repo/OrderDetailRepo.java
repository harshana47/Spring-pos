package org.example.z13_spring_boot.repo;

import org.example.z13_spring_boot.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepo extends JpaRepository<OrderDetails, Integer> {
}
