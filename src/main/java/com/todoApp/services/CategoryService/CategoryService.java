package com.todoApp.services.CategoryService;

import com.todoApp.entities.Category;
import com.todoApp.repositories.ICategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Category getById(Long id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public Category saveCategory(Category category) {
        categoryRepository.save(category);

        return category;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
