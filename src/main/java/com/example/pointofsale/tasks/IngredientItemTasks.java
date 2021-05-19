package com.example.pointofsale.tasks;

import com.example.pointofsale.daos.IngredientDao;
import com.example.pointofsale.daos.ItemDao;
import com.example.pointofsale.entities.Ingredient;
import com.example.pointofsale.entities.IngredientItem;
import com.example.pointofsale.entities.Item;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class IngredientItemTasks extends BaseTasks<IngredientItem> {
    @Autowired
    IngredientDao ingredientDao;

    @Autowired
    ItemDao itemDao;

    public IngredientItemTasks() {
        super("ingredientItem", IngredientItem.class);
    }

    @Override
    IngredientItem getNewEntity() {
        final List<Ingredient> ingredients = (List<Ingredient>) ingredientDao.allObjects();
        Ingredient ingredient = ingredients.get(RandomUtils.nextInt(0, ingredients.size() - 1));

        final List<Item> items = (List<Item>) itemDao.allObjects();
        Item item = items.get(RandomUtils.nextInt(0, items.size() - 1));

        return new IngredientItem(ingredient, item);
    }
}
