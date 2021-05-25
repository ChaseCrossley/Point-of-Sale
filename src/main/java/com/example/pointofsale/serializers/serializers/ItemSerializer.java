package com.example.pointofsale.serializers.serializers;

import com.example.pointofsale.entities.Item;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class ItemSerializer extends BaseSerializer<Item> {
    public ItemSerializer(Class<Item> itemClass) {
        super(itemClass);
    }

    @Override
    protected void serializeHelper(Item value, JsonGenerator jgen) throws IOException {
        jgen.writeStringField("name", value.getName());
        jgen.writeStringField("description", value.getDescription());
        jgen.writeObjectField("ingredientItems", value.getIngredientItems());
    }
}