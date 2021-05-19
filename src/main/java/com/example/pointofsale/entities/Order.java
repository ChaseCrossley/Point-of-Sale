package com.example.pointofsale.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="\"Order\"")
public class Order extends BaseEntity {

    @NotEmpty
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = OrderItem.class, mappedBy = "order")
    private Set<OrderItem> items;

    @NotNull
    @JoinColumn(name = "fk_userId", referencedColumnName = "id")
    @ManyToOne(targetEntity = User.class)
    private User customer;

    public Order() {
        super();
    }

    public Order(User customer) {
        this.customer = customer;
    }

    public Order(Set<OrderItem> items, User customer) {
        this.items = items;
        this.customer = customer;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }
}
