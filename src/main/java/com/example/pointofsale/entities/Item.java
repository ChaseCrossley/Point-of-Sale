package com.example.pointofsale.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Item")
public class Item extends BaseEntity {

    @OneToMany(targetEntity = IngredientItem.class, mappedBy = "ingredient")
    private Set<IngredientItem> ingredientItems;

    private String name;
    private String description;

    public Item() {
        super();
    }

    public Item(IngredientItem ingredientItem) {
        super();
        ingredientItems = new HashSet<>();
        ingredientItems.add(ingredientItem);
    }

    public Item(Set<IngredientItem> ingredientItems) {
        super();
        this.ingredientItems = ingredientItems;
    }

    public Set<IngredientItem> getIngredientItems() {
        return ingredientItems;
    }

    public void setIngredientItems(Set<IngredientItem> ingredientItems) {
        this.ingredientItems = ingredientItems;
    }

    public void addOneIngredientItem(IngredientItem ingredientItem) {
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
