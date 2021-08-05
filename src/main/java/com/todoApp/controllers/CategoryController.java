package com.todoApp.controllers;

import com.todoApp.entities.Category;
import com.todoApp.services.CategoryService.CategoryService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<Category> saveCategory(@RequestBody @Validated Category category) {

        System.out.println(category);

        if(category == null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error", "Ошибка");

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.categoryService.saveCategory(category);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") Long categoryId) {
        Category category = this.categoryService.getById(categoryId);

        if(category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.categoryService.deleteCategory(categoryId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") Long categoryId) {
        Category category = this.categoryService.getById(categoryId);

        if(category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categoryList = this.categoryService.getAllCategories();

        if(categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(categoryList ,HttpStatus.OK);
    }

    @PutMapping("edit/{/id}")
    public ResponseEntity<Category> editCategory(@RequestBody @Validated Category candidateCategory, @PathVariable("id") Long id) {
        Category category = this.categoryService.getById(id);

        if(category == null) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        Category editCategory = this.categoryService.saveCategory(candidateCategory);

        return new ResponseEntity<Category>(editCategory, HttpStatus.OK);
    }
}
