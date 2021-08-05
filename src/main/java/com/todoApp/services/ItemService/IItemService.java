package com.todoApp.services.ItemService;

import com.todoApp.entities.Category;
import com.todoApp.entities.Item;

import java.util.List;

public interface IItemService {
    Item getById(Long id);
    Item saveItem(Item item);
    void deleteItem(Long id);
    List<Item> getAllItems();
}
