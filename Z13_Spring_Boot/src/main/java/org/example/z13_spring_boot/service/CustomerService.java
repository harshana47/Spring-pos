package org.example.z13_spring_boot.service;

import org.example.z13_spring_boot.dto.CustomerDTO;
import org.example.z13_spring_boot.entity.Customer;
import org.example.z13_spring_boot.impl.CustomerServiceImpl;
import org.example.z13_spring_boot.repo.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CustomerServiceImpl {
    @Autowired
    private CustomerRepo customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
//        Customer customer = new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress());
        if (customerRepository.existsById(customerDTO.getId())) {
            throw new RuntimeException("Customer already exists");
        }
        customerRepository.save(modelMapper.map(customerDTO, Customer.class));
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
//        List<Customer> customers = customerRepository.findAll();
//        List<CustomerDTO> customerDTOs = new ArrayList<>();
//        for (Customer customer : customers) {
//            customerDTOs.add(new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress()));
//        }
//        return customerDTOs;
        return modelMapper.map(customerRepository.findAll(),new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if (customerRepository.existsById(customerDTO.getId())) {
//            Customer customer = new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress());
            customerRepository.save(modelMapper.map(customerDTO, Customer.class));
        }
        throw new RuntimeException("Customer does not exist");
    }

    @Override
    public void deleteCustomer(int id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        }
        throw new RuntimeException("Customer does not exist");
    }
}
