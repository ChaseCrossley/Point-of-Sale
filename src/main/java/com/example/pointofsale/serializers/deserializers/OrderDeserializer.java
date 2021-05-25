package com.example.pointofsale.serializers.deserializers;

import com.example.pointofsale.daos.OrderItemDao;
import com.example.pointofsale.daos.UserDao;
import com.example.pointofsale.entities.Order;
import com.example.pointofsale.entities.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.Set;

@Configurable
public class OrderDeserializer extends BaseDeserializer<Order> {

    @Autowired
    UserDao userDao;
    @Autowired
    OrderItemDao orderItemDao;

    public OrderDeserializer() {
        super();
    }

    public OrderDeserializer(Class<Order> orderClass) {
        super(orderClass);
    }

    @Override
    protected Order deserializeHelper(Order order) {
        order.setCustomer(userDao.getById(order.getCustomer().getId()));
        Set<OrderItem> orderItems = order.getItems();
        orderItems.forEach((orderItem) -> orderItem = orderItemDao.getById(orderItem.getId()));
        return order;
    }

}
