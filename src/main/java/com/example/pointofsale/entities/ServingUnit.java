package com.example.pointofsale.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "ServingUnit", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "abbreviation"}))
public class ServingUnit extends BaseEntity {

    @NotBlank
    private String name;

    @NotBlank
    private String abbreviation;

    public ServingUnit() {
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String aberration) {
        this.abbreviation = aberration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
