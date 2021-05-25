package com.example.pointofsale.validation;

import com.example.pointofsale.daos.ServingDao;
import com.example.pointofsale.entities.Serving;
import com.example.pointofsale.entities.ServingUnit;
import com.example.pointofsale.tasks.ItemTasks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.transaction.TransactionSystemException;

@SpringBootTest
class ServingValidationTests {

    @Autowired
    ItemTasks itemTasks;

    @Autowired
    ServingDao servingDao;

    Serving serving;

    @BeforeEach
    public void creatServing() {
        serving = itemTasks.getNewServing();
    }

    /* @NotNull */
    @Test
    public void testAmountValidation() {
        //given
        Serving serving = this.serving;

        //when
        serving.setAmount(null);

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> servingDao.create(serving));
    }

    /* @NotNull */
    @Test
    public void testItemValidation() {
        //given
        Serving serving = this.serving;

        //when id is not null so item not in DB
        serving.setServingUnit(new ServingUnit());

        //then
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class,
                () -> servingDao.create(serving));

        //when
        serving.setServingUnit(null);

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> servingDao.create(serving));
    }

}
