package com.todoApp.services.CategoryService;

import com.todoApp.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICategoryService {
    Category getById(Long id);
    Category saveCategory(Category category);
    void deleteCategory(Long id);
    List<Category> getAllCategories();
}
