package com.example.pointofsale.validation;

import com.example.pointofsale.daos.ItemDao;
import com.example.pointofsale.entities.Item;
import com.example.pointofsale.tasks.ItemTasks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import java.util.HashSet;

@SpringBootTest
class ItemValidationTests {

    @Autowired
    ItemTasks itemTasks;

    @Autowired
    ItemDao itemDao;

    Item item;

    @BeforeEach
    public void creatItem() {
        item = itemTasks.getNewEntity();
    }

    /* @NotEmpty */
    @Test
    public void testIngredientItemValidation() {
        //given
        Item item = this.item;

        //when
        item.setIngredientItems(new HashSet<>());

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> itemDao.create(item));
    }

    /* @Size(min = 2) */
    @Test
    public void testNameValidation() {
        //given
        Item item = this.item;

        //when
        item.setName("a");

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> itemDao.create(item));
    }

    /* @Size(min = 2) */
    @Test
    public void testDescriptionValidation() {
        //given
        Item item = this.item;

        //when
        item.setDescription("a");

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> itemDao.create(item));
    }

}
