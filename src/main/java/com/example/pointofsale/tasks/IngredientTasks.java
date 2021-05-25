package com.example.pointofsale.tasks;

import com.example.pointofsale.entities.Ingredient;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;


@Component
public class IngredientTasks extends BaseTasks<Ingredient> {
    @Autowired
    ServingUnitDao servingUnitDao;

    public IngredientTasks() {
        super("ingredient", Ingredient.class);
    }

    @Override
    public Ingredient getNewEntity() {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(1, NAME_MAX_SIZE)));
        return ingredient;
    }
}

