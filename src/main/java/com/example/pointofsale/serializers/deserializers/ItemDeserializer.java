package com.example.pointofsale.serializers.deserializers;

import com.example.pointofsale.daos.IngredientItemDao;
import com.example.pointofsale.entities.IngredientItem;
import com.example.pointofsale.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.Set;

@Configurable
public class ItemDeserializer extends BaseDeserializer<Item> {

    @Autowired
    IngredientItemDao ingredientItemDao;

    public ItemDeserializer() {
        super();
    }

    public ItemDeserializer(Class<Item> itemClass) {
        super(itemClass);
    }

    @Override
    protected Item deserializeHelper(Item item) {
        Set<IngredientItem> ingredientList = item.getIngredientItems();
        ingredientList.forEach((ingredientItem) -> ingredientItem = ingredientItemDao.getById(ingredientItem.getId()));
        return item;
    }

}
