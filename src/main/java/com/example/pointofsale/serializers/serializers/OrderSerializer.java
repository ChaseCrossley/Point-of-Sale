package com.example.pointofsale.serializers.serializers;

import com.example.pointofsale.entities.Order;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class OrderSerializer extends BaseSerializer<Order> {
    public OrderSerializer(Class<Order> orderClass) {
        super(orderClass);
    }

    @Override
    protected void serializeHelper(Order value, JsonGenerator jgen) throws IOException {
        jgen.writeObjectField("customer", value.getCustomer());
        jgen.writeObjectField("items", value.getItems());
    }
}