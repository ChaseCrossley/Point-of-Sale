package com.example.pointofsale.entities;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "ServingUnit")
public class ServingUnit extends BaseEntity {

    @NotEmpty
    @NaturalId
    private String name;

    @NotEmpty
    @NaturalId
    private String abbreviation;

    public ServingUnit(String name, String abbreviation) {
        super();
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public ServingUnit() {
        super();
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
