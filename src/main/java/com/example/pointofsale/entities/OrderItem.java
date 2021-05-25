package com.example.pointofsale.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "OrderItem")
public class OrderItem extends BaseEntity {

    @NotNull
    @JoinColumn(name = "fk_orderId", referencedColumnName = "id")
    @JsonIgnore
    @ManyToOne(targetEntity = Order.class)
    Order order;

    @NotNull
    @JoinColumn(name = "fk_itemId", referencedColumnName = "id")
    @ManyToOne(targetEntity = Item.class)
    Item item;

    @OneToMany(targetEntity = AddInIngredient.class, cascade = CascadeType.ALL, mappedBy = "orderItem", fetch = FetchType.EAGER)
    Set<AddInIngredient> addInIngredient;

    public OrderItem() {
        setAddInIngredient(new HashSet<>());
    }

    public Set<AddInIngredient> getAddInIngredient() {
        return addInIngredient;
    }

    public void setAddInIngredient(Set<AddInIngredient> addInIngredient) {
        this.addInIngredient = addInIngredient;
        this.addInIngredient.forEach((addInIngredient1) -> addInIngredient1.setOrderItem(this));
    }

    public void addAddInIngredientItem(AddInIngredient addInIngredient) {
        addInIngredient.setOrderItem(this);
        this.addInIngredient.add(addInIngredient);
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
