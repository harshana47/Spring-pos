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
        boolean res = itemService.addItem(itemDTO);
        if(res){
            return new ResponseUtil(201,"Item Saved",null);
        }else {
            return new ResponseUtil(200,"Exist Item",null);
        }
    }
    @GetMapping("getAll")
    public List<ItemDTO> getAllItems(){
        return itemService.getAllItems();
    }
    @PutMapping("update")
    public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO){
        boolean res = itemService.updateItem(itemDTO);
        if(res){
            return new ResponseUtil(201,"Item Updated",null);
        }else {
            return new ResponseUtil(200,"error updating Item",null);
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseUtil deleteItem(@PathVariable("id") String id){
        boolean res = itemService.deleteItem(Integer.parseInt(id));
        if(res){
            return new ResponseUtil(201,"Item Deleted",null);
        }else {
            return new ResponseUtil(200,"Error Deleting Item",null);
        }
    }
}
