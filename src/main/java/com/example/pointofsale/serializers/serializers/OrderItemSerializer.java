package com.example.pointofsale.serializers.serializers;

import com.example.pointofsale.entities.OrderItem;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class OrderItemSerializer extends BaseSerializer<OrderItem> {
    public OrderItemSerializer(Class<OrderItem> orderItemClass) {
        super(orderItemClass);
    }

    @Override
    protected void serializeHelper(OrderItem value, JsonGenerator jgen) throws IOException {
        jgen.writeObjectField("order", value.getOrder().getId());
        jgen.writeObjectField("item", value.getItem());
    }
}