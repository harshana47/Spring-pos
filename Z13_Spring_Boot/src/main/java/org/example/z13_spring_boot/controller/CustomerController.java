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
        boolean res = customerService.addCustomer(customerDTO);
        if(res){
            return new ResponseUtil(201,"Customer Saved",null);
        }else {
            return new ResponseUtil(200,"Exist Customer",null);
        }
    }
    @GetMapping("getAll")
    public List<CustomerDTO> getAllCustomers() {
        customerService.getAllCustomers();
        return customerService.getAllCustomers();
    }
    @PutMapping("update")
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {
        boolean res = customerService.updateCustomer(customerDTO);
        if(res){
            return new ResponseUtil(201,"Customer Updated",null);
        }else {
            return new ResponseUtil(200,"Error Updating Customer",null);
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseUtil deleteCustomer(@PathVariable("id") String id) {
        boolean res = customerService.deleteCustomer(Integer.parseInt(id));
        if(res){
            return new ResponseUtil(201,"Customer Deleted",null);
        }else {
            return new ResponseUtil(200,"Error Deleting Customer",null);
        }
    }
}
