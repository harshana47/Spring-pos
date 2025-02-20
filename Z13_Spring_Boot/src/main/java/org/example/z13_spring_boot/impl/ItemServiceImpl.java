package org.example.z13_spring_boot.impl;

import org.example.z13_spring_boot.dto.ItemDTO;
import org.example.z13_spring_boot.entity.Item;

import java.util.ArrayList;
import java.util.List;

public interface ItemServiceImpl {
    public boolean addItem(ItemDTO itemDTO);

    public List<ItemDTO> getAllItems();

    public boolean updateItem(ItemDTO itemDTO);

    public boolean deleteItem(int id);
}
