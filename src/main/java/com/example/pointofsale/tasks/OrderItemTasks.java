//package com.example.pointofsale.tasks;
//
//import com.example.pointofsale.daos.ItemDao;
//import com.example.pointofsale.daos.OrderDao;
//import com.example.pointofsale.entities.Item;
//import com.example.pointofsale.entities.Order;
//import com.example.pointofsale.entities.OrderItem;
//import org.apache.commons.lang3.RandomUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class OrderItemTasks extends BaseTasks<OrderItem> {
//
//    @Autowired
//    OrderDao orderDao;
//    @Autowired
//    ItemDao itemDao;
//
//    public OrderItemTasks() {
//        super("orderItem", OrderItem.class);
//    }
//
//    @Override
//    public  OrderItem getNewEntity() {
//        final List<Order> orders = (List<Order>) orderDao.allObjects();
//        Order order = orders.get(RandomUtils.nextInt(0, orders.size() - 1));
//
//        final List<Item> items = (List<Item>) itemDao.allObjects();
//        Item item = items.get(RandomUtils.nextInt(0, items.size() - 1));
//
//        return new OrderItem(order, item);
//    }
//}
