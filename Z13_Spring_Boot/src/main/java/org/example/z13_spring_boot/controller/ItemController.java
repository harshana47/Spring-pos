package org.example.z13_spring_boot.controller;

import org.example.z13_spring_boot.dto.ItemDTO;
import org.example.z13_spring_boot.service.ItemService;
import org.example.z13_spring_boot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("save")
    public ResponseUtil saveItem(@RequestBody ItemDTO itemDTO){
        System.out.println(itemDTO.getName());
        itemService.addItem(itemDTO);
        return new ResponseUtil(201,"Item Saved",null);
    }
    @GetMapping("getAll")
    public ResponseUtil getAllItems(){
        return new ResponseUtil(
                200,
                "Customer List",
                itemService.getAllItems());
    }
    @PutMapping("update")
    public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO){
        itemService.updateItem(itemDTO);
        return new ResponseUtil(201,"Item Updated",null);
    }
    @DeleteMapping("delete/{id}")
    public ResponseUtil deleteItem(@PathVariable("id") String id){
        itemService.deleteItem(Integer.parseInt(id));
        return new ResponseUtil(201,"Item Deleted",null);
    }
}
