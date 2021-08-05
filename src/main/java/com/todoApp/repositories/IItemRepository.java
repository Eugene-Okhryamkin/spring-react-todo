package com.todoApp.repositories;

import com.todoApp.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemRepository extends JpaRepository<Item, Long> {

}
