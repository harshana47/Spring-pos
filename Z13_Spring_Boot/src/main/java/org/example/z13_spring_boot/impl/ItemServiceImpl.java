package org.example.z13_spring_boot.impl;

import org.example.z13_spring_boot.dto.ItemDTO;
import org.example.z13_spring_boot.entity.Item;

import java.util.ArrayList;
import java.util.List;

public interface ItemServiceImpl {
    public void addItem(ItemDTO itemDTO);

    public List<ItemDTO> getAllItems();

    public void updateItem(ItemDTO itemDTO);

    public void deleteItem(int id);
}
