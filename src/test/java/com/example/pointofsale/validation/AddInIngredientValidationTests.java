package com.example.pointofsale.validation;

import com.example.pointofsale.daos.AddInIngredientDao;
import com.example.pointofsale.entities.AddInIngredient;
import com.example.pointofsale.entities.Ingredient;
import com.example.pointofsale.entities.OrderItem;
import com.example.pointofsale.entities.Serving;
import com.example.pointofsale.tasks.OrderTasks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.transaction.TransactionSystemException;

@SpringBootTest
class AddInIngredientValidationTests {

    @Autowired
    OrderTasks orderTasks;

    @Autowired
    AddInIngredientDao addInIngredientDao;

    AddInIngredient addInIngredient;

    @BeforeEach
    public void creatAddInIngredient() {
        addInIngredient = orderTasks.getNewAddInIngredient();
    }

    /* @NotNull */
    @Test
    public void testIngredientValidation() {
        //given
        AddInIngredient addInIngredient = this.addInIngredient;

        //when id is not null so item not in DB
        addInIngredient.setIngredient(new Ingredient());

        //then
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class,
                () -> addInIngredientDao.create(addInIngredient));

        //when
        addInIngredient.setIngredient(null);

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> addInIngredientDao.create(addInIngredient));
    }

    /* @NotNull */
    @Test
    public void testOrderItemValidation() {
        //given
        AddInIngredient addInIngredient = this.addInIngredient;

        //when id is not null so item not in DB
        addInIngredient.setOrderItem(new OrderItem());

        //then
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class,
                () -> addInIngredientDao.create(addInIngredient));

        //when
        addInIngredient.setOrderItem(null);

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> addInIngredientDao.create(addInIngredient));

    }

    /* @NotNull */
    @Test
    public void testServingValidation() {
        //given
        AddInIngredient addInIngredient = this.addInIngredient;

        //when id is not null so item not in DB
        addInIngredient.setServing(new Serving());

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> addInIngredientDao.create(addInIngredient));

        //when
        addInIngredient.setServing(null);

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> addInIngredientDao.create(addInIngredient));

    }

}
