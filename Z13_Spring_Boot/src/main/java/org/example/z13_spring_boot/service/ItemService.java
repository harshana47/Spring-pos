package org.example.z13_spring_boot.service;

import org.example.z13_spring_boot.dto.ItemDTO;
import org.example.z13_spring_boot.entity.Item;
import org.example.z13_spring_boot.impl.ItemServiceImpl;
import org.example.z13_spring_boot.repo.ItemRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements ItemServiceImpl {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addItem(ItemDTO itemDTO) {
//        Item item = new Item(itemDTO.getId(),itemDTO.getName(),itemDTO.getDescription(),itemDTO.getQty(),itemDTO.getPrice());
        if (itemRepo.existsById(itemDTO.getId())){
            throw new RuntimeException("item already exists");
        }
        Item item = modelMapper.map(itemDTO, Item.class);
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return modelMapper.map(itemRepo.findAll(), new TypeToken<List<ItemDTO>>() {}.getType());
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getId())){
            throw new RuntimeException("item already exists");
        }
        Item item = modelMapper.map(itemDTO, Item.class);
    }

    @Override
    public void deleteItem(int id) {
        if (itemRepo.existsById(id)) {
            itemRepo.deleteById(id);
        }
        throw new RuntimeException("item does not exist");
    }
}
