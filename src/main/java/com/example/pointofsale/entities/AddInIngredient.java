package com.example.pointofsale.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class AddInIngredient extends BaseEntity {

    @NotNull
    @JoinColumn(name = "fk_ingredientId", referencedColumnName = "id")
    @ManyToOne(targetEntity = Ingredient.class)
    private Ingredient ingredient;

    @NotNull
    @JoinColumn(name = "fk_orderItemId", referencedColumnName = "id")
    @JsonIgnore
    @ManyToOne(targetEntity = OrderItem.class)
    private OrderItem orderItem;

    @NotNull
    @JoinColumn(name = "fk_servingId", referencedColumnName = "id")
    @OneToOne(targetEntity = Serving.class, cascade = {CascadeType.ALL})
    private Serving serving;

    public AddInIngredient() {
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public Serving getServing() {
        return serving;
    }

    public void setServing(Serving serving) {
        this.serving = serving;
    }
}
