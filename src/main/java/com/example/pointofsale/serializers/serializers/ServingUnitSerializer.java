package com.example.pointofsale.serializers.serializers;

import com.example.pointofsale.entities.ServingUnit;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class ServingUnitSerializer extends BaseSerializer<ServingUnit> {
    public ServingUnitSerializer(Class<ServingUnit> servingUnitClass) {
        super(servingUnitClass);
    }

    @Override
    protected void serializeHelper(ServingUnit value, JsonGenerator jgen) throws IOException {
        jgen.writeStringField("name", value.getName());
        jgen.writeStringField("abbreviation", value.getAbbreviation());
    }
}