package com.example.pointofsale.serializers.serializers;

import com.example.pointofsale.entities.Ingredient;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class IngredientSerializer extends BaseSerializer<Ingredient> {
    public IngredientSerializer(Class<Ingredient> ingredientClass) {
        super(ingredientClass);
    }

    @Override
    protected void serializeHelper(Ingredient value, JsonGenerator jgen) throws IOException {
        jgen.writeStringField("name", value.getName());
    }
}