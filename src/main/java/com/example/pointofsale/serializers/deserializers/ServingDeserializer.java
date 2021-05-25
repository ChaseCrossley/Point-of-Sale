package com.example.pointofsale.serializers.deserializers;

import com.example.pointofsale.daos.ServingUnitDao;
import com.example.pointofsale.entities.Serving;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class ServingDeserializer extends BaseDeserializer<Serving> {

    @Autowired
    ServingUnitDao servingUnitDao;

    public ServingDeserializer() {
        super();
    }


    public ServingDeserializer(Class<Serving> servingClass) {
        super(servingClass);
    }

    @Override
    protected Serving deserializeHelper(Serving serving) {
        serving.setServingUnit(servingUnitDao.getById(serving.getServingUnit().getId()));
        return serving;
    }

}
