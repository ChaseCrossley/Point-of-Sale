package com.example.pointofsale.entities;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Proxy(lazy = false)
@Table(name = "IngredientItem")
public class IngredientItem extends BaseEntity {

    @NotNull
    @JoinColumn(name = "fk_ingredientId", referencedColumnName = "id")
    @ManyToOne(targetEntity = Ingredient.class)
    Ingredient ingredient;

    @NotNull
    @JoinColumn(name = "fk_itemId", referencedColumnName = "id")
    @ManyToOne(targetEntity = Item.class)
    Item item;

    public IngredientItem() {
        super();
    }

    public IngredientItem(Ingredient ingredient, Item item) {
        this.ingredient = ingredient;
        this.item = item;
    }

    public IngredientItem(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
