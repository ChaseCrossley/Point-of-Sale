package com.example.pointofsale.serializers;

import com.example.pointofsale.daos.*;
import com.example.pointofsale.entities.*;
import com.example.pointofsale.serializers.serializers.UserSerializer;
import com.example.pointofsale.tasks.*;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SerializerTests {

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
    public void testUserSerializer() throws IOException {
        // given
        User user = userTasks.getNewEntity();
        UserSerializer userSerializer = new UserSerializer(User.class);

        // when
        StringWriter stringWriter = new StringWriter();
        JsonGenerator jsonGenerator =
                new JsonFactory().createGenerator(stringWriter);
        userSerializer.serialize(user, jsonGenerator, null);
        String string = stringWriter.toString(); // string is ""
        assertNotNull(string);
        assertTrue(string.length() > 0);
        stringWriter.close();
    }

    @Test
    public void testEmployeePersistence() {
        // given
        Employee employee = employeeTasks.getNewEntity();

        // when
        employeeDao.create(employee);

        // then
        assertNotNull(employee.getId());
    }

    @Test
    public void testIngredientPersistence() {
        // given
        Ingredient ingredient = ingredientTasks.getNewEntity();

        // when
        ingredientDao.create(ingredient);

        // then
        assertNotNull(ingredient.getId());
    }

    @Test
    public void testServingUnitPersistence() {
        // given
        ServingUnit servingUnit = servingUnitTasks.getNewEntity();

        // when
        servingUnitDao.create(servingUnit);

        // then
        assertNotNull(servingUnit.getId());
    }

    @Test
    public void testItemPersistence() {
        // given
        Item item = itemTasks.getNewEntity();

        // when
        itemDao.create(item);

        // then
        assertNotNull(item.getId());
    }

    @Test
    public void testOrderPersistence() {
        // given
        Order order = orderTasks.getNewEntity();

        // when
        orderDao.create(order);

        // then
        assertNotNull(order.getId());
    }

}
