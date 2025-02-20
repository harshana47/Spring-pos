package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("params")
public class ParamsController {

    @GetMapping(params = {"id"})
    public String test1(@RequestParam("id") String id){
        return id;
    }

    //http://localhost:8080/09_RESTController_Web_exploded/params?id=47&name=vagi
    @GetMapping(params = {"id", "name"})
    public String test2(@RequestParam("id") String id, @RequestParam("name") String name){
        return id + ", " + name;
    }

    @GetMapping(path = "/*", params = {"id", "name"})
    public String test3(@RequestParam("id") String id, @RequestParam("name") String name) {
        return id + ", " + name;
    }

}
