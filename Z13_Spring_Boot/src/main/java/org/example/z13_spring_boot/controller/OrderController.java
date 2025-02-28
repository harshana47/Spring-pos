package org.example.z13_spring_boot.controller;

import org.example.z13_spring_boot.dto.OrdersDTO;
import org.example.z13_spring_boot.service.OrderService;
import org.example.z13_spring_boot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("save")
    public ResponseUtil saveOrder(@RequestBody OrdersDTO ordersDTO) {
        boolean res = orderService.addOrder(ordersDTO);
        if(res){
            return new ResponseUtil(201,"Item Saved",null);
        }else {
            return new ResponseUtil(200,"Exist Item",null);
        }
    }
}
