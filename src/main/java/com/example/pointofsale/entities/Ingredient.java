package com.example.pointofsale.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Ingredient", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class Ingredient extends BaseEntity {

    @NotBlank
    private String name;

    public Ingredient() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}