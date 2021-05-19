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
    ServingUnit getNewEntity() {
        return new ServingUnit(RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(2));
    }
}
