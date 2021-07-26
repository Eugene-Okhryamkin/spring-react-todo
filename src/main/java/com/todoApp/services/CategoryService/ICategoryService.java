package com.todoApp.services.CategoryService;

import com.todoApp.entities.Category;

import java.util.List;

public interface ICategoryService {
    Category getById(Long id);
    void saveCategory(Category category);
    void deleteCategory(Long id);
    List<Category> getAllCategories();
}
