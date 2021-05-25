package com.example.pointofsale.entities;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity extends AbstractPersistable<Integer> {

    boolean deleted = false;

    public BaseEntity() {
        super();
    }

    public void setId(Integer id) {
        super.setId(id);
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "id=" + getId() +
                ", new=" + isNew() +
                '}';
    }
}