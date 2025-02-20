package org.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping
    public String seyHello() {
        return "get mapping Invoked";
    }

    @PostMapping
    public String seyHelloPost() {
        return "post mapping Invoked";
    }
    @DeleteMapping
    public String seyHelloDelete() {
        return "delete mapping Invoked";
    }
    @PutMapping
    public String seyHelloPut() {
        return "put mapping Invoked";
    }
    @PatchMapping
    public String seyHelloPatch() {
        return "patch mapping Invoked";
    }
}
