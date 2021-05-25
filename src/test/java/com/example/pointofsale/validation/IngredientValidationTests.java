package com.example.pointofsale.validation;

import com.example.pointofsale.daos.IngredientDao;
import com.example.pointofsale.entities.Ingredient;
import com.example.pointofsale.tasks.IngredientTasks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

@SpringBootTest
class IngredientValidationTests {

    @Autowired
    IngredientTasks ingredientTasks;

    @Autowired
    IngredientDao ingredientDao;

    Ingredient ingredient;

    @BeforeEach
    public void creatIngredient() {
        ingredient = ingredientTasks.getNewEntity();
    }

    /* @NotBlank */
    @Test
    public void testNameValidation() {
        //given
        Ingredient ingredient = this.ingredient;

        //when
        ingredient.setName("");

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> ingredientDao.create(ingredient));
    }
}
