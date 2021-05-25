package com.example.pointofsale.serializers.deserializers;

import com.example.pointofsale.daos.IngredientDao;
import com.example.pointofsale.daos.ItemDao;
import com.example.pointofsale.daos.ServingDao;
import com.example.pointofsale.entities.IngredientItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class IngredientItemDeserializer extends BaseDeserializer<IngredientItem> {

    @Autowired
    IngredientDao ingredientDao;
    @Autowired
    ItemDao itemDao;
    @Autowired
    ServingDao servingDao;

    public IngredientItemDeserializer() {
        super();
    }

    public IngredientItemDeserializer(Class<IngredientItem> ingredientItemClass) {
        super(ingredientItemClass);
    }

    @Override
    protected IngredientItem deserializeHelper(IngredientItem ingredientItem) {
        ingredientItem.setIngredient(ingredientDao.getById(ingredientItem.getIngredient().getId()));
        ingredientItem.setItem(itemDao.getById(ingredientItem.getItem().getId()));
        ingredientItem.setServing(servingDao.getById(ingredientItem.getServing().getId()));
        return ingredientItem;
    }

}
