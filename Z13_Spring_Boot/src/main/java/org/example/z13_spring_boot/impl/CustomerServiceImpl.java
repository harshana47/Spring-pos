package org.example.z13_spring_boot.impl;

import org.example.z13_spring_boot.dto.CustomerDTO;

import java.util.List;

public interface CustomerServiceImpl {

    public void addCustomer(CustomerDTO customerDTO);
    public List<CustomerDTO> getAllCustomers();
    public void updateCustomer(CustomerDTO customerDTO);
    public void deleteCustomer(int id);
}
