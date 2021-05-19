package com.example.pointofsale.daos;

import com.example.pointofsale.entities.OrderItem;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OrderItemDao extends BaseDao<OrderItem>{
    public OrderItemDao() {
        super(OrderItem.class);
    }
}