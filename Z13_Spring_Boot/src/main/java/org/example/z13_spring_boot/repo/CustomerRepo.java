package org.example.z13_spring_boot.repo;

import org.example.z13_spring_boot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
