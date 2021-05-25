package com.example.pointofsale.tasks;

import com.example.pointofsale.daos.IngredientDao;
import com.example.pointofsale.daos.ServingUnitDao;
import com.example.pointofsale.entities.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;


@Component
public class ItemTasks extends BaseTasks<Item> {

    private static final int MAX_INGREDIENT_ITEMS = 6;
    @Autowired
    IngredientDao ingredientDao;
    @Autowired
    ServingUnitDao servingUnitDao;

    public ItemTasks() {
        super("item", Item.class);
    }

    @Override
    public Item getNewEntity() {
        Item item = new Item();
        item.setDescription(RandomStringUtils.randomAlphabetic(10));
        item.setName(RandomStringUtils.randomAlphabetic(10));
        item.setIngredientItems(new HashSet<>());
        for (int i = 0; i < RandomUtils.nextInt(0, MAX_INGREDIENT_ITEMS); i++) {
            IngredientItem ingredientItem = getNewIngredientItem();
            item.addOneIngredientItem(ingredientItem);
        }
        return item;
    }

    public IngredientItem getNewIngredientItem() {
        final List<Ingredient> ingredients = (List<Ingredient>) ingredientDao.allObjects();
        Ingredient ingredient = ingredients.get(RandomUtils.nextInt(0, ingredients.size() - 1));

        IngredientItem ingredientItem = new IngredientItem();

        ingredientItem.setIngredient(ingredient);
        ingredientItem.setServing(getNewServing());
        return ingredientItem;
    }

    public Serving getNewServing() {
        final List<ServingUnit> servingUnits = (List<ServingUnit>) servingUnitDao.allObjects();
        ServingUnit servingUnit = servingUnits.remove(RandomUtils.nextInt(0, servingUnits.size() - 1));

        Serving serving = new Serving();

        serving.setAmount(RandomUtils.nextFloat());
        serving.setServingUnit(servingUnit);

        return serving;
    }
}
