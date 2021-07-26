package com.todoApp.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "Item")
@Getter
@Setter
@ToString
public class Item extends MainEntity {
    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "CategoryId")
    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category category;
}
