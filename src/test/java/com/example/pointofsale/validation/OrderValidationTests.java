package com.example.pointofsale.validation;

import com.example.pointofsale.daos.OrderDao;
import com.example.pointofsale.entities.Order;
import com.example.pointofsale.entities.User;
import com.example.pointofsale.tasks.OrderTasks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import java.util.HashSet;

@SpringBootTest
class OrderValidationTests {

    @Autowired
    OrderTasks orderTasks;

    @Autowired
    OrderDao orderDao;

    Order order;

    @BeforeEach
    public void creatOrder() {
        order = orderTasks.getNewEntity();
    }

    /* @NotEmpty */
    @Test
    public void testItemsValidation() {
        //given
        Order order = this.order;

        //when
        order.setItems(new HashSet<>());

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> orderDao.create(order));
    }

    /* @Size(min = 2) */
    @Test
    public void testCustomerValidation() {
        //given
        Order order = this.order;

        //when
        order.setCustomer(new User());

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> orderDao.create(order));
    }

}
