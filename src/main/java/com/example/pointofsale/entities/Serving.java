package com.example.pointofsale.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Serving")
public class Serving extends BaseEntity {
    @NotNull
    private Float amount;

    @NotNull
    @ManyToOne(targetEntity = ServingUnit.class)
    @JoinColumn(name = "fk_servingUnitId", referencedColumnName = "id")
    private ServingUnit servingUnit;

    public Serving() {
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public ServingUnit getServingUnit() {
        return servingUnit;
    }

    public void setServingUnit(ServingUnit servingUnit) {
        this.servingUnit = servingUnit;
    }
}
