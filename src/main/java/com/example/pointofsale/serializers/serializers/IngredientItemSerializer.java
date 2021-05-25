package com.example.pointofsale.serializers.serializers;

import com.example.pointofsale.entities.IngredientItem;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class IngredientItemSerializer extends BaseSerializer<IngredientItem> {
    public IngredientItemSerializer(Class<IngredientItem> ingredientItemClass) {
        super(ingredientItemClass);
    }

    @Override
    protected void serializeHelper(IngredientItem value, JsonGenerator jgen) throws IOException {
        jgen.writeObjectField("ingredient", value.getIngredient());
        jgen.writeObjectField("item", value.getItem().getId());
        jgen.writeObjectField("serving", value.getServing());
    }
}