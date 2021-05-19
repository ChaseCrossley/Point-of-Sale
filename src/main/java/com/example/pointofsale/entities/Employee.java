package com.example.pointofsale.entities;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Employee")
public class Employee extends BaseEntity {

    @NaturalId
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    @SequenceGenerator(name = "USERS_SEQ", sequenceName = "SEQUENCE_USERS")
    private Integer employeeId;

    @JoinColumn(name = "fk_userId", referencedColumnName = "id")
    @OneToOne(targetEntity = User.class)
    @NotNull
    private User user;

    public Employee() {
        super();
        this.user = user;
    }

    public Employee(User user) {
        super();
        this.user = user;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
