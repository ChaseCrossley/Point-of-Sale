package com.example.pointofsale.serializers.serializers;

import com.example.pointofsale.entities.AddInIngredient;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class AddInIngredientSerializer extends BaseSerializer<AddInIngredient> {
    public AddInIngredientSerializer(Class<AddInIngredient> addInIngredientClass) {
        super(addInIngredientClass);
    }

    @Override
    protected void serializeHelper(AddInIngredient value, JsonGenerator jgen) throws IOException {
        jgen.writeObjectField("ingredient", value.getIngredient());
        jgen.writeObjectField("orderItem", value.getOrderItem());
        jgen.writeObjectField("serving", value.getServing());
    }
}