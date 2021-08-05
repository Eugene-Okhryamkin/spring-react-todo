package com.todoApp.controllers;

import com.todoApp.entities.Item;
import com.todoApp.services.ItemService.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items/")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public ResponseEntity<Item> saveItem(@RequestBody @Validated Item item) {
        if(item == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.itemService.saveItem(item);

        return new ResponseEntity<Item>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@RequestBody @Validated Long id) {
        if(id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Item item = this.itemService.getById(id);

        if(item == null) {
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> itemList = this.itemService.getAllItems();

        if(itemList.isEmpty()) {
            return new ResponseEntity<List<Item>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Item>>(itemList, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Item> deleteItemById(@PathVariable("id") Long itemId) {
        Item item = this.itemService.getById(itemId);

        if(item == null) {
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }

        this.itemService.deleteItem(itemId);

        return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Item> editItem(@PathVariable("id") Long itemId, @RequestBody @Validated Item candidateItem) {
        Item item = this.itemService.getById(itemId);

        if(item == null) {
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }

        Item editedItem = this.itemService.saveItem(candidateItem);

        return new ResponseEntity<Item>(editedItem, HttpStatus.OK);
    }
}
