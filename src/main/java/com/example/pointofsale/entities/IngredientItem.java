package com.example.pointofsale.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
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
    @JsonIgnore
    @JoinColumn(name = "fk_itemId", referencedColumnName = "id")
    @ManyToOne(targetEntity = Item.class)
    Item item;

    @NotNull
    @JoinColumn(name = "fk_servingId", referencedColumnName = "id")
    @OneToOne(targetEntity = Serving.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Serving serving;

    public IngredientItem() {
    }

    public Serving getServing() {
        return serving;
    }

    public void setServing(Serving serving) {
        this.serving = serving;
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
