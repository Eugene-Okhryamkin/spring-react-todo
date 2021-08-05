package com.todoApp.services.ItemService;

import com.todoApp.entities.Category;
import com.todoApp.entities.Item;
import com.todoApp.repositories.IItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ItemService implements IItemService {

    @Autowired
    IItemRepository itemRepository;

    @Override
    public Item getById(Long id) {
        return this.itemRepository.getOne(id);
    }

    @Override
    public Item saveItem(Item item) {
        this.itemRepository.save(item);

        return item;
    }

    @Override
    public void deleteItem(Long id) {
        this.itemRepository.deleteById(id);
    }


    @Override
    public List<Item> getAllItems() {
        return this.itemRepository.findAll();
    }

}
