package com.example.pointofsale.serializers.serializers;

import com.example.pointofsale.entities.Serving;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class ServingSerializer extends BaseSerializer<Serving> {
    public ServingSerializer(Class<Serving> servingClass) {
        super(servingClass);
    }

    @Override
    protected void serializeHelper(Serving value, JsonGenerator jgen) throws IOException {
        jgen.writeObjectField("amount", value.getAmount());
        jgen.writeObjectField("servingUnit", value.getServingUnit());
    }
}