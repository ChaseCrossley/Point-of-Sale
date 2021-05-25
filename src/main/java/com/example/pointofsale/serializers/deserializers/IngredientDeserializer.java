package com.example.pointofsale.serializers.deserializers;

import com.example.pointofsale.entities.Ingredient;

public class IngredientDeserializer extends BaseDeserializer<Ingredient> {
    public IngredientDeserializer(Class<Ingredient> ingredientClass) {
        super(ingredientClass);
    }

    @Override
    protected Ingredient deserializeHelper(Ingredient ingredient) {
        return ingredient;
    }

}
