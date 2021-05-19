package com.example.pointofsale.tasks;

import com.example.pointofsale.daos.ServingUnitDao;
import com.example.pointofsale.entities.Ingredient;
import com.example.pointofsale.entities.ServingUnit;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class IngredientTasks extends BaseTasks<Ingredient> {
    @Autowired
    ServingUnitDao servingUnitDao;

    public IngredientTasks() {
        super("ingredient", Ingredient.class);
    }

    @Override
    Ingredient getNewEntity() {
        final List<ServingUnit> servingUnits = (List<ServingUnit>) servingUnitDao.allObjects();
        ServingUnit servingUnit = servingUnits.get(RandomUtils.nextInt(0, servingUnits.size() - 1));
        return new Ingredient(RandomUtils.nextInt(1, 10), RandomUtils.nextInt(), servingUnit);
    }
}
