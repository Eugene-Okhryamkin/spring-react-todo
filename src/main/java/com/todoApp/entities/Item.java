package com.todoApp.entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "item")
@Getter
@Setter
@ToString
public class Item extends MainEntity {
    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "description")
    @NonNull
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
