package com.example.pointofsale;

import com.example.pointofsale.daos.*;
import com.example.pointofsale.entities.*;
import com.example.pointofsale.tasks.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersistenceTests {

    @Autowired
    UserTasks userTasks;
    @Autowired
    UserDao userDao;
    @Autowired
    EmployeeTasks employeeTasks;
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    IngredientTasks ingredientTasks;
    @Autowired
    IngredientDao ingredientDao;
    @Autowired
    ItemTasks itemTasks;
    @Autowired
    ItemDao itemDao;
    @Autowired
    ServingUnitTasks servingUnitTasks;
    @Autowired
    ServingUnitDao servingUnitDao;
    @Autowired
    OrderTasks orderTasks;
    @Autowired
    OrderDao orderDao;

    @Test
    public void testUserPersistence() {
        // given
        User user = userTasks.getNewEntity();

        // when
        userDao.create(user);

        // then
        Assertions.assertNotNull(user.getId());
    }

    @Test
    public void testEmployeePersistence() {
        // given
        Employee employee = employeeTasks.getNewEntity();

        // when
        employeeDao.create(employee);

        // then
        Assertions.assertNotNull(employee.getId());
    }

    @Test
    public void testIngredientPersistence() {
        // given
        Ingredient ingredient = ingredientTasks.getNewEntity();

        // when
        ingredientDao.create(ingredient);

        // then
        Assertions.assertNotNull(ingredient.getId());
    }

    @Test
    public void testServingUnitPersistence() {
        // given
        ServingUnit servingUnit = servingUnitTasks.getNewEntity();

        // when
        servingUnitDao.create(servingUnit);

        // then
        Assertions.assertNotNull(servingUnit.getId());
    }

    @Test
    public void testItemPersistence() {
        // given
        Item item = itemTasks.getNewEntity();

        // when
        itemDao.create(item);

        // then
        Assertions.assertNotNull(item.getId());
    }

    @Test
    public void testOrderPersistence() {
        // given
        Order order = orderTasks.getNewEntity();

        // when
        orderDao.create(order);

        // then
        Assertions.assertNotNull(order.getId());
    }
}