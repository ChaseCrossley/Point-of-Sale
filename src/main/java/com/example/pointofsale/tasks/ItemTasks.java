package com.example.pointofsale.tasks;

import com.example.pointofsale.daos.IngredientItemDao;
import com.example.pointofsale.entities.Item;
import com.example.pointofsale.entities.IngredientItem;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ItemTasks extends BaseTasks<Item> {
    @Autowired
    IngredientItemDao ingredientItemDao;

    public ItemTasks() {
        super("item", Item.class);
    }

    @Override
    Item getNewEntity() {
        final List<IngredientItem> ingredientItems = (List<IngredientItem>) ingredientItemDao.allObjects();
        IngredientItem ingredientItem = ingredientItems.get(RandomUtils.nextInt(0, ingredientItems.size() - 1));
        return new Item(ingredientItem);
    }
}
