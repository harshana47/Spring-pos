package org.example.z13_spring_boot.controller;

import org.example.z13_spring_boot.dto.CustomerDTO;
import org.example.z13_spring_boot.service.CustomerService;
import org.example.z13_spring_boot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("save")
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println(customerDTO.getName());
        customerService.addCustomer(customerDTO);
        return new ResponseUtil(201,"Customer Saved",null);
    }
    @GetMapping("getAll")
    public ResponseUtil getAllCustomers() {
        return new ResponseUtil(
                200,
                "Customer List",
                customerService.getAllCustomers());
    }
    @PutMapping("update")
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(customerDTO);
        return new ResponseUtil(200,"Customer Updated",null);
    }
    @DeleteMapping("delete/{id}")
    public ResponseUtil deleteCustomer(@PathVariable("id") String id) {
        customerService.deleteCustomer(Integer.parseInt(id));
        return new ResponseUtil(200,"Customer Deleted",null);
    }
}
