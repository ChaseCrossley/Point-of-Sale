package com.example.pointofsale.validation;

import com.example.pointofsale.daos.OrderItemDao;
import com.example.pointofsale.entities.Item;
import com.example.pointofsale.entities.Order;
import com.example.pointofsale.entities.OrderItem;
import com.example.pointofsale.tasks.OrderTasks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

@SpringBootTest
class OrderItemValidationTests {

    @Autowired
    OrderTasks orderTasks;

    @Autowired
    OrderItemDao orderItemDao;

    OrderItem orderItem;

    @BeforeEach
    public void creatOrderItem() {
        orderItem = orderTasks.getOrderItem();
    }

    /* @NotNull */
    @Test
    public void testOrderValidation() {
        //given
        OrderItem orderItem = this.orderItem;

        //when id is not null so item not in DB
        orderItem.setOrder(new Order());

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> orderItemDao.create(orderItem));
    }

    /* @NotNull */
    @Test
    public void testItemValidation() {
        //given
        OrderItem orderItem = this.orderItem;

        //when id is not null so item not in DB
        orderItem.setItem(new Item());

        //then
        Assertions.assertThrows(TransactionSystemException.class,
                () -> orderItemDao.create(orderItem));
    }

}
