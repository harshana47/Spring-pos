package org.example.controller;

import org.example.DTO.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("json")
public class JsonController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String test1(@RequestBody CustomerDTO customerDTO){
        return customerDTO.toString();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO test2(){
        return new CustomerDTO("vagi","magi",47);
    }

    @GetMapping(path = "getAll",produces =MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CustomerDTO> test3() {
        ArrayList<CustomerDTO> list = new ArrayList<>();
        list.add(new CustomerDTO("vagi","magi",47));
        list.add(new CustomerDTO("vagi2","magi2",48));
        list.add(new CustomerDTO("vagi3","magi3",22));
        return list;
    }
}
