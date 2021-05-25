package com.example.pointofsale.tasks;

import com.example.pointofsale.entities.ServingUnit;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;


@Component
public class ServingUnitTasks extends BaseTasks<ServingUnit> {

    public ServingUnitTasks() {
        super("servingUnit", ServingUnit.class);
    }

    @Override
    public ServingUnit getNewEntity() {
        ServingUnit servingUnit = new ServingUnit();
        servingUnit.setName(RandomStringUtils.randomAlphabetic(10));
        servingUnit.setAbbreviation(RandomStringUtils.randomAlphabetic(2));

        return servingUnit;
    }
}
