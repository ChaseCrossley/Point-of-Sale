package com.example.pointofsale.validation;

import com.example.pointofsale.daos.IngredientItemDao;
import com.example.pointofsale.entities.Ingredient;
import com.example.pointofsale.entities.IngredientItem;
import com.example.pointofsale.entities.Item;
import com.example.pointofsale.entities.Serving;
import com.example.pointofsale.tasks.ItemTasks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.transaction.TransactionSystemException;

@SpringBootTest
class IngredientItemValidationTests {

    @Autowired
    ItemTasks itemTasks;

    @Autowired
    IngredientItemDao ingredientItemDao;

    IngredientItem ingredientItem;

    @BeforeEach
    public void creatIngredientItem() {
        ingredientItem = itemTasks.getNewIngredientItem();
    }

    /* @NotNull */
    @Test
    public void testIngredientValidation() {
        //given
        IngredientItem ingredientItem = this.ingredientItem;

        //when id is not null so item not in DB
        ingredientItem.setIngredient(new Ingredient());

        //then
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class,
                () -> ingredientItemDao.create(ingredientItem));

        //when
        ingredientItem.setIngredient(null);

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> ingredientItemDao.create(ingredientItem));
    }

    /* @NotNull */
    @Test
    public void testItemValidation() {
        //given
        IngredientItem ingredientItem = this.ingredientItem;

        //when id is not null so item not in DB
        ingredientItem.setItem(new Item());

        //then
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class,
                () -> ingredientItemDao.create(ingredientItem));

        //when
        ingredientItem.setItem(null);

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> ingredientItemDao.create(ingredientItem));

    }

    /* @NotNull */
    @Test
    public void testServingValidation() {
        //given
        IngredientItem ingredientItem = this.ingredientItem;

        //when id is not null so item not in DB
        ingredientItem.setServing(new Serving());

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> ingredientItemDao.create(ingredientItem));

        //when
        ingredientItem.setServing(null);

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> ingredientItemDao.create(ingredientItem));

    }

}
