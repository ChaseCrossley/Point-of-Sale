package com.example.pointofsale.entities;

import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity extends AbstractAuditable<User, Integer> {

    boolean deleted = false;

    public BaseEntity() {
        super();
        setLastModifiedDate(LocalDateTime.now());
        setCreatedDate(LocalDateTime.now());
    }

    public BaseEntity(int id) {
        super();
        this.setId(id);
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
                ", createdBy=" + getCreatedBy() +
                ", createdDate=" + getCreatedDate() +
                ", lastModifiedBy=" + getLastModifiedBy() +
                ", lastModifiedDate=" + getLastModifiedDate() +
                '}';
    }
}