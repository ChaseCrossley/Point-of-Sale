package com.example.pointofsale.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Item")
public class Item extends BaseEntity {

    @NotEmpty
    @OneToMany(targetEntity = IngredientItem.class, mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<IngredientItem> ingredientItems;

    @Size(min = 2)
    private String name;
    @Size(min = 2)
    private String description;

    public Item() {
        setIngredientItems(new HashSet<>());
    }

    public Set<IngredientItem> getIngredientItems() {
        return ingredientItems;
    }

    public void setIngredientItems(Set<IngredientItem> ingredientItems) {
        this.ingredientItems = ingredientItems;
        this.ingredientItems.forEach((ingredientItem) -> ingredientItem.setItem(this));
    }

    public void addOneIngredientItem(IngredientItem ingredientItem) {
        ingredientItem.setItem(this);
        this.ingredientItems.add(ingredientItem);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
