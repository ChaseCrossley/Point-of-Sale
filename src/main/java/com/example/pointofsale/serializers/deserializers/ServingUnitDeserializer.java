package com.example.pointofsale.serializers.deserializers;

import com.example.pointofsale.entities.ServingUnit;

public class ServingUnitDeserializer extends BaseDeserializer<ServingUnit> {
    public ServingUnitDeserializer(Class<ServingUnit> servingUnitClass) {
        super(servingUnitClass);
    }


    @Override
    protected ServingUnit deserializeHelper(ServingUnit servingUnit) {
        return servingUnit;
    }

}
