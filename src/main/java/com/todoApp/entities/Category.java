package com.todoApp.entities;

import com.todoApp.entities.MainEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Categories")
@Getter
@Setter
@ToString
public class Category extends MainEntity {

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;
}
