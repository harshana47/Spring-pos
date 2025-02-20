package org.example.z13_spring_boot.impl;

import org.example.z13_spring_boot.dto.CustomerDTO;

import java.util.List;

public interface CustomerServiceImpl {

    public boolean addCustomer(CustomerDTO customerDTO);
    public List<CustomerDTO> getAllCustomers();
    public boolean updateCustomer(CustomerDTO customerDTO);
    public boolean deleteCustomer(int id);
}
