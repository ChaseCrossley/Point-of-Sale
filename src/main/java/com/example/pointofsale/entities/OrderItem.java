package com.example.pointofsale.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "OrderItem")
public class OrderItem extends BaseEntity {

    @NotNull
    @JoinColumn(name = "fk_orderId", referencedColumnName = "id")
    @ManyToOne(targetEntity = Order.class)
    Order order;

    @NotNull
    @JoinColumn(name = "fk_itemId", referencedColumnName = "id")
    @ManyToOne(targetEntity = Item.class)
    Item item;

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
