package com.todoApp.repositories;

import com.todoApp.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
