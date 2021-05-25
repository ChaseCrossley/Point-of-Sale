package com.example.pointofsale.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Ingredient", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class Ingredient extends BaseEntity {

    @NotNull
    private Integer servingSize;
    @NotNull
    private Integer servingAmount;
    @NotNull
    private Long timesUsed;

    @NotNull
    @JoinColumn(name = "fk_servingUnitId", referencedColumnName = "id")
    @ManyToOne(targetEntity = ServingUnit.class)
    private ServingUnit unit;


    public Ingredient() {
        this.servingSize = servingSize;
        this.servingAmount = servingAmount;
        this.timesUsed = timesUsed;
        this.unit = unit;
    }

    public Ingredient(Integer servingSize, Integer servingAmount, ServingUnit unit) {
        this.servingSize = servingSize;
        this.servingAmount = servingAmount;
        this.unit = unit;
        this.timesUsed = 1L;
    }

    public Ingredient(Integer servingSize, Integer servingAmount, Long timesUsed, ServingUnit unit) {
        this.servingSize = servingSize;
        this.servingAmount = servingAmount;
        this.timesUsed = timesUsed;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public Long getTimesUsed() {
        return timesUsed;
    }

    public void setTimesUsed(Long timesUsed) {
        this.timesUsed = timesUsed;
    }

    public ServingUnit getUnit() {
        return unit;
    }

    public void setUnit(ServingUnit unit) {
        this.unit = unit;
    }

    public Integer getServingSize() {
        return servingSize;
    }

    public void setServingSize(Integer servingSize) {
        this.servingSize = servingSize;
    }
}