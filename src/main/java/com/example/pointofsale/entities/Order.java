package com.example.pointofsale.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"Order\"")
public class Order extends BaseEntity {

    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL, targetEntity = OrderItem.class, mappedBy = "order", fetch = FetchType.EAGER)
    private Set<OrderItem> items;

    @NotNull
    @JoinColumn(name = "fk_userId", referencedColumnName = "id")
    @ManyToOne(targetEntity = User.class)
    private User customer;

    public Order() {
        setItems(new HashSet<>());
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
        this.items.forEach((item) -> item.setOrder(this));
    }

    public void addOneItem(OrderItem item) {
        item.setOrder(this);
        this.items.add(item);
    }
}
