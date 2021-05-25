package com.example.pointofsale.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Employee")
public class Employee extends BaseEntity {

    @JoinColumn(name = "fk_userId", referencedColumnName = "id")
    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @NotNull
    private User user;

    public Employee() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
