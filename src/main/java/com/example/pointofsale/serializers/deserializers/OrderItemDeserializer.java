package com.example.pointofsale.serializers.deserializers;

import com.example.pointofsale.daos.ItemDao;
import com.example.pointofsale.daos.OrderDao;
import com.example.pointofsale.entities.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;


@Configurable
public class OrderItemDeserializer extends BaseDeserializer<OrderItem> {

    @Autowired
    OrderDao orderDao;

    @Autowired
    ItemDao itemDao;

    public OrderItemDeserializer() {
        super();
    }

    public OrderItemDeserializer(Class<OrderItem> orderItemClass) {
        super(orderItemClass);
    }

    @Override
    protected OrderItem deserializeHelper(OrderItem orderItem) {
        orderItem.setItem(itemDao.getById(orderItem.getItem().getId()));
        orderItem.setOrder(orderDao.getById(orderItem.getOrder().getId()));
        return orderItem;
    }

}
