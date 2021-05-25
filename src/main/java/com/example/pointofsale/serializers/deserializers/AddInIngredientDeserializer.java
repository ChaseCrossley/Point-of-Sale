package com.example.pointofsale.serializers.deserializers;

import com.example.pointofsale.daos.IngredientDao;
import com.example.pointofsale.daos.OrderItemDao;
import com.example.pointofsale.daos.ServingDao;
import com.example.pointofsale.entities.AddInIngredient;
import org.springframework.beans.factory.annotation.Autowired;

public class AddInIngredientDeserializer extends BaseDeserializer<AddInIngredient> {
    //AddInIngredient Add DAO Class for each relation defined

    @Autowired
    IngredientDao ingredientDao;
    @Autowired
    OrderItemDao orderItemDao;
    @Autowired
    ServingDao servingDao;

    public AddInIngredientDeserializer() {
        super();
    }

    public AddInIngredientDeserializer(Class<AddInIngredient> addInIngredientClass) {
        super(addInIngredientClass);
    }

    @Override
    protected AddInIngredient deserializeHelper(AddInIngredient addInIngredient) {
        addInIngredient.setIngredient(ingredientDao.getById(addInIngredient.getIngredient().getId()));
        addInIngredient.setOrderItem(orderItemDao.getById(addInIngredient.getOrderItem().getId()));
        addInIngredient.setServing(servingDao.getById(addInIngredient.getServing().getId()));
        return addInIngredient;
    }

}
