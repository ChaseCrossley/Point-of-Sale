package com.example.pointofsale.validation;

import com.example.pointofsale.daos.ServingUnitDao;
import com.example.pointofsale.entities.ServingUnit;
import com.example.pointofsale.tasks.ServingUnitTasks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

@SpringBootTest
class ServingUnitValidationTests {

    @Autowired
    ServingUnitTasks servingUnitTasks;

    @Autowired
    ServingUnitDao servingUnitDao;

    ServingUnit servingUnit;

    @BeforeEach
    public void creatServingUnit() {
        servingUnit = servingUnitTasks.getNewEntity();
    }

    /* @NotBlank */
    @Test
    public void testNameValidation() {
        //given
        ServingUnit servingUnit = this.servingUnit;

        //when
        servingUnit.setName("");

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> servingUnitDao.create(servingUnit));
    }

    /* @NotBlank */
    @Test
    public void testItemValidation() {
        //given
        ServingUnit servingUnit = this.servingUnit;

        //when
        servingUnit.setAbbreviation("");

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> servingUnitDao.create(servingUnit));

    }

}
